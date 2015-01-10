package cz.cvut.fel.si.schmipe4.persistence.dao.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import play.Logger;

public class CartDAOImpl implements CartDAO {
    @Override
    public void addCart(Cart cart) {
        Logger.debug("Adding Cart " + cart.getCustomer());
        cart.save();
    }

    @Override
    public void updateCart(Cart cart) {
        Logger.debug("Updating Cart " + cart.getCustomer());
        cart.update();
    }

    @Override
    public void deleteCart(String customer) {
        Logger.debug("Deleting Cart " + customer);
        Cart.finder.byId(customer).delete();
    }

    @Override
    public Cart getCartById(String customer) {
        Logger.debug("Getting Cart " + customer);
        return Cart.finder.byId(customer);
    }
}
