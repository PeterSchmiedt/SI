package service;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.ItemService;
import cz.cvut.fel.si.schmipe4.service.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class ItemServiceTest extends WithApplication {

    ItemService itemService;

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());

        itemService = new ItemServiceImpl();

        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    @Test
    public void registerItemAndSelectCategoryTest() {
        Category c = new Category("kategoria", null);
        Item i = new Item("vec", "popis", 200);

        assertTrue(itemService.registerItemAndSelectCategory(i, c));

        Item itemdb = Item.finder.byId(i.getId());
        assertNotNull(itemdb);
        Category categorydb = Category.finder.byId(c.getId());
        assertNotNull(categorydb);

        assertEquals(itemdb.getCategories().iterator().next().getId(), categorydb.getId());

    }
}
