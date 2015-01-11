package cz.cvut.fel.si.schmipe4.persistence.dao;

import cz.cvut.fel.si.schmipe4.persistence.model.Category;

public interface CategoryDAO {

    public void addCategory(Category category);

    public void updateCategoty(Category category);

    public void deleteCatogeory(Integer id);

    public Category getCategoryById(Integer id);

}
