package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class ItemDAOTest extends WithApplication {

    ItemDAO itemDAO;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());
        itemDAO = new DAOFactory().getItemDaoImpl();
    }

    @Test
    public void add() {
        Item i = new Item("item1", "description1", 100);
        itemDAO.addItem(i);
        assertEquals(i.getId(), Item.finder.byId(i.getId()).getId());
    }

    @Test
    public void update() {
        Item i = new Item("item1", "description1", 100);
        itemDAO.addItem(i);
        i.setDescription("newDescription");
        itemDAO.updateItem(i);
        assertEquals(i.getDescription(), Item.finder.byId(i.getId()).getDescription());
    }

    @Test
    public void delete() {
        Item i = new Item("item1", "description1", 100);
        itemDAO.addItem(i);
        itemDAO.deleteItem(i.getId());
        assertNull(Item.finder.byId(i.getId()));
    }

    @Test
    public void get() {
        Item i = new Item("item1", "description1", 100);
        itemDAO.addItem(i);
        Item iFromDAO = itemDAO.getItemById(i.getId());
        Item iFromDB = Item.finder.byId(i.getId());
        assertEquals(iFromDB.getId(), iFromDAO.getId());
    }
}
