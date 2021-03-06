package cz.cvut.fel.si.schmipe4.service.implv2;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import cz.cvut.fel.si.schmipe4.persistence.model.CartItem;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.CartService;
import org.joda.time.DateTime;
import play.Logger;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CartServiceImplV2 implements CartService {

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    public CartServiceImplV2() {
        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    /*

    2. - nákup nesmí obsahovat více než 10 položek daného produktu ------
    3. Osoba smí nakupovat v jeden den jen 1x -----------
    4. registrace zboží nesmí mít totožný název ---------

    7. Loggujte do Loggeru

     */

    @Override
    public boolean shop(Cart cart) {
        Cart c = cartDAO.getCartById(cart.getCustomer());
        if (c == null) return false;
        cart.setShop(true);
        cartDAO.updateCart(cart);
        return true;
    }

    @Override
    public boolean addToCart(Cart cart, Item item, int quantity) {
        if (quantity > 10) return false;

        if (cart.isShop()) {
            Logger.debug("addToCart isShop = true - " + cart.getCustomer());
            DateTime cartDate = new DateTime(cart.getDate());
            DateTime current = new DateTime(new Date());

            //check if the
            if (cartDate.getDayOfYear() == current.getDayOfYear()) {
                Logger.debug("addToCart - the customer made a purchase today.");
                return false;
            }

            cart.setItems(new HashSet<>());
            cart.setDate(new Date());
            cart.setTotal(0);
            cart.setShop(false);
            cartDAO.updateCart(cart);
        }


        Item i = itemDAO.getItemById(item.getId());
        if (i == null) {
            Logger.debug("addToCart - Item does not exist.");
            return false;
        }

        Cart c = cartDAO.getCartById(cart.getCustomer());


        if (c == null) {
            cart.addItem(i, quantity);
            cartDAO.addCart(cart);
        } else {
            for (CartItem ci : c.getItems()) {
                if (ci.getItem().getId() == i.getId()) {
                    //v kosiku uz jeden taky item je
                    if (ci.getQuantity() + quantity > 10) {
                        Logger.debug("addToCart - Quantity is too much for this item " + i.getName() + " in this cart " + cart.getCustomer());
                        return false;
                    }
                }
            }

            cart.addItem(i, quantity);
            cartDAO.updateCart(cart);
        }
        return true;
    }

    @Override
    public double getTotal(Cart cart) {
        return cart.getTotal();
    }

    @Override
    public double getTotalForCategory(Category category) {
        Category categoryDB = categoryDAO.getCategoryById(category.getId());
        Set<Cart> carts = cartDAO.getAll();
        double total = 0;

        for (Cart cart : carts) {
            for (CartItem ci : cart.getItems()) {
                if (ci.getItem().getCategories().contains(categoryDB)) {
                    //count here
                    total += (ci.getItem().getPrice() * ci.getQuantity());
                }
            }
        }
        return total;
    }

    @Override
    public double getTotalForDay(Date date) {
        Set<Cart> carts = cartDAO.getAll();
        double total = 0;

        DateTime dateTime = new DateTime(date);


        for (Cart cart : carts) {
            DateTime cartTime = new DateTime(cart.getDate());
            if (cartTime.getDayOfYear() == dateTime.getDayOfYear() && cartTime.getYear() == dateTime.getYear()) {
                for (CartItem ci : cart.getItems()) {
                    //count here
                    total += (ci.getItem().getPrice() * ci.getQuantity());
                }
            }
        }

        return total;
    }
}
