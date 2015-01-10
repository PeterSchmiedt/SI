package cz.cvut.fel.si.schmipe4.service.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.ItemService;

public class ItemServiceImpl implements ItemService {

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    public ItemServiceImpl() {
        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    @Override
    public boolean registerItemAndSelectCategory(Item item, Category category) {
        Item itemDB = itemDAO.getItemById(item.getId());
        Category categoryDB = categoryDAO.getCategoryById(category.getId());
        if (itemDB == null) {
            item.getCategories().add(category);

            if (categoryDB == null) {
                categoryDAO.addCategory(category);
                itemDAO.addItem(item);
                return true;
            } else {
                itemDAO.addItem(item);
                return true;
            }

        } else {
            item.getCategories().add(category);

            if (categoryDB == null) {
                categoryDAO.addCategory(category);
                itemDAO.updateItem(item);
                return true;
            } else {
                itemDAO.updateItem(item);
                return true;
            }
        }
    }
}
