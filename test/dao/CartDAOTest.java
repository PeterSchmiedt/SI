package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class CartDAOTest extends WithApplication {

    CartDAO cartDAO;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());
        cartDAO = new DAOFactory().getCartDaoImpl();
    }

    @Test
    public void add() {
        Cart c = new Cart("customer1", new Date());
        cartDAO.addCart(c);
        assertEquals(c.getCustomer(), Cart.finder.byId(c.getCustomer()).getCustomer());
    }

    @Test
    public void update() {
        Cart c = new Cart("customer1", new Date());
        cartDAO.addCart(c);
        c.setDate(new Date(100000000));
        cartDAO.updateCart(c);

        assertEquals(c.getDate().getTime(), Cart.finder.byId(c.getCustomer()).getDate().getTime());
    }

    @Test
    public void delete() {
        Cart c = new Cart("customer1", new Date());
        cartDAO.addCart(c);
        cartDAO.deleteCart(c.getCustomer());
        assertNull(Cart.finder.byId(c.getCustomer()));
    }

    @Test
    public void get() {
        Cart c = new Cart("customer1", new Date());
        cartDAO.addCart(c);

        Cart cFromDAO = cartDAO.getCartById(c.getCustomer());
        Cart cFromDB = Cart.finder.byId(c.getCustomer());

        assertEquals(cFromDB.getCustomer(), cFromDAO.getCustomer());
    }
}
