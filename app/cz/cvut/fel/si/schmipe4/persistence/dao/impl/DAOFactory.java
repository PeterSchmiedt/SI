package cz.cvut.fel.si.schmipe4.persistence.dao.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CartItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;

public class DAOFactory {

    public CartDAO getCartDaoImpl() {
        return new CartDAOImpl();
    }

    public CartItemDAO getCartItemDAOImpl() {
        return new CartItemDAOImpl();
    }

    public CategoryDAO getCategoryDAOImpl() {
        return new CategoryDAOImpl();
    }

    public ItemDAO getItemDaoImpl() {
        return new ItemDAOImpl();
    }

}
