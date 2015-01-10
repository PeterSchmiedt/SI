package cz.cvut.fel.si.schmipe4.service.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import cz.cvut.fel.si.schmipe4.persistence.model.CartItem;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.service.CartService;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Set;

public class CartServiceImpl implements CartService {

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    public CartServiceImpl() {
        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    @Override
    public boolean shop() {
        return false;
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
        //TODO tu by sa hodilo cartDAO.getForToday(Date date)...

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
