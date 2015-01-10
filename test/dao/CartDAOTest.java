package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CartDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

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
