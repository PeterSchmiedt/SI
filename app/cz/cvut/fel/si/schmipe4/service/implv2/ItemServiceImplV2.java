package cz.cvut.fel.si.schmipe4.service.implv2;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.ItemService;

import java.util.Set;

public class ItemServiceImplV2 implements ItemService {

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    public ItemServiceImplV2() {
        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    /*
    *
    * 5. Kategorie se nesmí opakovat-------
      6. Kategoriie nesmí být nadkategorií/podkategoríí již přiřazenou ke zboží - musi byt jednoducha struktura stromu-----------
            1. Boty - nesmí být běžecké boty a obráceně = jen jedna - kategorie se nesmi cyklit ...---------------------------
    * */

    @Override
    public boolean registerItemAndSelectCategory(Item item, Category category) {
        Item itemDB = itemDAO.getItemById(item.getId());
        Category categoryDB = categoryDAO.getCategoryById(category.getId());
        if (!checkInvariant(category)) {
            return false;
        }
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

    private boolean checkInvariant(Category category) {
        Category parent = category.getParent();
        if (parent == null) return true;
        Set<Category> subcategories = category.getSubcategories();
        if (subcategories == null) return true;

        for (Category c : subcategories) {
            if (parent.getId() == c.getId()) return false;
        }
        return true;
    }
}
