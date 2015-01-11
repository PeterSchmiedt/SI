package controllers;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.CartService;
import cz.cvut.fel.si.schmipe4.service.implv2.CartServiceImplV2;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cartdetail;
import views.html.index;

import java.util.Date;

public class CartController extends Controller {

    private final static String title = "Shopping Cart";
    private static DAOFactory daof = new DAOFactory();
    private static CartService cartService = new CartServiceImplV2();


    public static Result getCartDetail() {
        CartDAO cartDAO = daof.getCartDaoImpl();
        Cart cart = cartDAO.getCartById(session().get("username"));

        if (cart == null) {
            cart = new Cart(session().get("username"), new Date());
            cartDAO.addCart(cart);
        }

        return ok(cartdetail.render(title, session().get("username"), cart));
    }

    public static Result addToCart(int id) {
        //FORM spracuj
        Form<AddToCart> form = Form.form(AddToCart.class).bindFromRequest(new String[0]);
        if (form.hasErrors()) {
            return redirect(routes.Application.index());
        }

        ItemDAO itemDAO = daof.getItemDaoImpl();

        Item item = itemDAO.getItemById(id);

        if (item == null) {
            return ok(index.render(title, session().get("username"), itemDAO.getAll()));
        }

        CartDAO cartDAO = daof.getCartDaoImpl();

        Cart cart = cartDAO.getCartById(session().get("username"));

        if (cartService.addToCart(cart, item, form.get().getQuantity())) {
            //added
            return ok(cartdetail.render(title, session().get("username"), cart));
        }

        return redirect(routes.Application.index());
    }

    public static class AddToCart {
        public int quantity;

        public String validate() {
            if (quantity > 10) return "Too much quantity.";
            return null;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
