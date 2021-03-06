package cz.cvut.fel.si.schmipe4.persistence.dao;

import cz.cvut.fel.si.schmipe4.persistence.model.Item;

import java.util.Set;

public interface ItemDAO {

    public void addItem(Item item);

    public void updateItem(Item item);

    public void deleteItem(int id);

    public Item getItemById(int id);

    public Set<Item> getAll();
}
