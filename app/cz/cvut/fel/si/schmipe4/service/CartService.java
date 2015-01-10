package cz.cvut.fel.si.schmipe4.service;

import cz.cvut.fel.si.schmipe4.persistence.model.Cart;
import cz.cvut.fel.si.schmipe4.persistence.model.Category;

import java.util.Date;

public interface CartService {

    public boolean shop();

    public double getTotal(Cart cart);

    public double getTotalForCategory(Category category);

    public double getTotalForDay(Date date);

}
