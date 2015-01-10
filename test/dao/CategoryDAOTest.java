package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class CategoryDAOTest extends WithApplication {

    CategoryDAO categoryDAOdao;

    @Before
    public void setUp() {
        fakeApplication(inMemoryDatabase());
        categoryDAOdao = new DAOFactory().getCategoryDAOImpl();
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
