package serviceV2;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import cz.cvut.fel.si.schmipe4.service.ItemService;
import cz.cvut.fel.si.schmipe4.service.implv2.ItemServiceImplV2;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class ItemServiceV2Test extends WithApplication {

    ItemService itemService;

    DAOFactory daoFactory;
    CartDAO cartDAO;
    CategoryDAO categoryDAO;
    ItemDAO itemDAO;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());

        itemService = new ItemServiceImplV2();

        daoFactory = new DAOFactory();
        cartDAO = daoFactory.getCartDaoImpl();
        categoryDAO = daoFactory.getCategoryDAOImpl();
        itemDAO = daoFactory.getItemDaoImpl();
    }

    @Test
    public void registerItemAndSelectCategoryTest() {
        Category c1 = new Category("kategoria", null);
        Category c2 = new Category("podkategoria", c1);
        c1.setParent(c2);

        Item i = new Item("vec", "popis", 200);

        assertFalse(itemService.registerItemAndSelectCategory(i, c1));

        Item itemdb = Item.finder.byId(i.getId());
        assertNull(itemdb);
    }
}
