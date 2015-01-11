package cz.cvut.fel.si.schmipe4.persistence.dao.impl;

import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import play.Logger;

import java.util.Set;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public void addItem(Item item) {
        Logger.debug("Adding Item " + item.getName());
        item.save();
    }

    @Override
    public void updateItem(Item item) {
        Logger.debug("Updating  Item " + item.getName());
        item.update();
    }

    @Override
    public void deleteItem(int id) {
        Logger.debug("Deleting  Item " + id);
        Item.finder.byId(id).delete();
    }

    @Override
    public Item getItemById(int id) {
        Logger.debug("Getting  Item " + id);
        return Item.finder.byId(id);
    }

    @Override
    public Set<Item> getAll() {
        return Item.finder.findSet();
    }
}
