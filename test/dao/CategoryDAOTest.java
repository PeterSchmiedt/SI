package dao;

import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
        Category c = new Category("category", null);
        categoryDAOdao.addCategory(c);
        assertEquals(c.getId(), Category.finder.byId(c.getId()).getId());
    }

    @Test
    public void update() {
        Category c = new Category("category", null);
        categoryDAOdao.addCategory(c);
        c.setName("newCategory");
        categoryDAOdao.updateCategoty(c);
        assertEquals(c.getName(), Category.finder.byId(c.getId()).getName());
    }

    @Test
    public void delete() {
        Category c = new Category("category", null);
        categoryDAOdao.addCategory(c);
        categoryDAOdao.deleteCatogeory(c.getId());
        assertNull(Category.finder.byId(c.getId()));
    }

    @Test
    public void get() {
        Category c = new Category("category", null);
        categoryDAOdao.addCategory(c);
        Category cFromDAO = categoryDAOdao.getCategoryById(c.getId());
        Category cFromDB = Category.finder.byId(c.getId());
        assertEquals(cFromDB.getId(), cFromDAO.getId());
    }
}
