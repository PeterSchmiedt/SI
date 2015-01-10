package cz.cvut.fel.si.schmipe4.service;

import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;

import java.util.Date;

public interface CartService {

    public boolean shop();

    public boolean getTotal(Cart cart);

    public boolean getTotalForCategory(Cart cart, Category category);

    public boolean getTotalForDay(Date date);

}
