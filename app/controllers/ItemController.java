package controllers;

import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.ItemService;
import cz.cvut.fel.si.schmipe4.service.implv2.ItemServiceImplV2;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registercategory;

import java.util.Set;

public class ItemController extends Controller {

    private final static String title = "Shopping Cart";
    private static DAOFactory daof = new DAOFactory();
    private static ItemService cartService = new ItemServiceImplV2();

    public static Result addCategoryToItem() {
        CategoryDAO categoryDAO = daof.getCategoryDAOImpl();
        ItemDAO itemDAO = daof.getItemDaoImpl();

        Set<Item> itemSet = itemDAO.getAll();
        Set<Category> categorySet = categoryDAO.getAll();

        return ok(registercategory.render(title, session().get("username"), itemSet, categorySet));
    }


    public static class ItemCategory {
        public int itemId;
        public int categoryId;

        public String validate() {
            return null;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }
    }
}
