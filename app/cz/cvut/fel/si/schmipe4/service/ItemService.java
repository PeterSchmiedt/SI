package cz.cvut.fel.si.schmipe4.service;

import cz.cvut.fel.si.schmipe4.persistence.model.Category;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;

public interface ItemService {

    public boolean registerItemAndSelectCategory(Item item, Category category);

}
