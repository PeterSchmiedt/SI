package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.CartItem;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class CartItemDAOTest extends WithApplication {

    CartItemDAO cartItemDAO;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());
        cartItemDAO = new DAOFactory().getCartItemDAOImpl();
    }

    @Test
    public void add() {
//        Item i = new Item("item1", "description1", 100);
//        i.save();
//        CartItem ci = new CartItem(i, 5);
//        cartItemDAO.addCartItem(ci);
//        assertEquals(ci.getId(), CartItem.finder.byId(ci.getId()));
    }

    @Test
    public void update() {
//        Item i = new Item("item1", "description1", 100);
//        CartItem ci = new CartItem(i, 5);
//        cartItemDAO.addCartItem(ci);
//        ci.setQuantity(10);
//        cartItemDAO.updateCartItem(ci);
//        assertEquals(ci.getQuantity(), CartItem.finder.byId(ci.getId()));
    }

    @Test
    public void delete() {
//        Item i = new Item("item1", "description1", 100);
//        CartItem ci = new CartItem(i, 5);
//        cartItemDAO.addCartItem(ci);
    }

    @Test
    public void get() {

    }
}
