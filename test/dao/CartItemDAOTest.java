package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

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

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void get() {

    }
}
