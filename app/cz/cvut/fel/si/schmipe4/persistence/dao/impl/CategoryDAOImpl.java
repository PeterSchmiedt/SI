package cz.cvut.fel.si.schmipe4.persistence.dao.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.CategoryDAO;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import play.Logger;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public void addCategory(Category category) {
        Logger.debug("Adding Category " + category.getName());
        category.save();
    }

    @Override
    public void updateCategoty(Category category) {
        Logger.debug("Updating  Category " + category.getName());
        category.update();
    }

    @Override
    public void deleteCatogeory(int id) {
        Logger.debug("Deleting  Category " + id);
        Category.finder.byId(id).delete();
    }

    @Override
    public Category getCategoryById(int id) {
        Logger.debug("Getting Category " + id);
        return Category.finder.byId(id);
    }
}
