package cz.cvut.fel.si.schmipe4.persistence.dao;

import cz.cvut.fel.si.schmipe4.persistence.model.CartItem;

public interface CartItemDAO {

    public void addCartItem(CartItem cartItem);

    public void updateCartItem(CartItem cartItem);

    public void deleteCartItem(int id);

    public CartItem getCartItemById(int id);

}
