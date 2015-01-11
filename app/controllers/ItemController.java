package controllers;

import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.service.ItemService;
import cz.cvut.fel.si.schmipe4.service.implv2.ItemServiceImplV2;
import play.mvc.Controller;

public class ItemController extends Controller {

    private final static String title = "Shopping Cart";
    private static DAOFactory daof = new DAOFactory();
    private static ItemService cartService = new ItemServiceImplV2();


}
