package cz.cvut.fel.si.schmipe4.persistence.dao;

import cz.cvut.fel.si.schmipe4.persistence.model.Cart;

import java.util.Set;

public interface CartDAO {

    public void addCart(Cart cart);

    public void updateCart(Cart cart);

    public void deleteCart(String customer);

    public Cart getCartById(String customer);

    public Set<Cart> getAll();

}
