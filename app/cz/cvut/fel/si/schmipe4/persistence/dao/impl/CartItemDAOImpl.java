package cz.cvut.fel.si.schmipe4.persistence.dao.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.model.CartItem;
import play.Logger;

public class CartItemDAOImpl implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        Logger.debug("Adding CartItem" + cartItem.getId());
        cartItem.save();
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        Logger.debug("Updating CartItem" + cartItem.getId());
        cartItem.update();
    }

    @Override
    public void deleteCartItem(int id) {
        Logger.debug("Deleting  CartItem" + id);
        CartItem.finder.byId(id).delete();
    }

    @Override
    public CartItem getCartItemById(int id) {
        Logger.debug("Getting  CartItem" + id);
        return CartItem.finder.byId(id);
    }
}
