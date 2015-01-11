package controllers;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cartdetail;

import java.util.Date;

public class CartController extends Controller {

    private final static String title = "Shopping Cart";
    private static DAOFactory daof = new DAOFactory();

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

        return ok();
    }
}
