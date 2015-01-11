package controllers;

import cz.cvut.fel.si.schmipe4.persistence.dao.ItemDAO;
import cz.cvut.fel.si.schmipe4.persistence.dao.impl.DAOFactory;
import cz.cvut.fel.si.schmipe4.persistence.model.Item;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.login;

import java.util.Set;

public class Application extends Controller {

    private final static String title = "Shopping Cart";
    private static DAOFactory daof = new DAOFactory();

    public static Result index() {



        /*Category main;// = new Category("main");
        Category submain;// = new Category("submain");
        Category subsubmain;// = new Category("subsubmain");

        Item item1;//= new Item("item1", "description", 100);
        Item item2;// = new Item("item2", "description", 200);
        Item item3;// = new Item("item3", "description", 300);
        Item item4;// = new Item("item4", "description", 400);
        Item item5;// = new Item("item5", "description", 500);
        Item item6;// = new Item("item6", "description", 600);
        Item item7;// = new Item("item7", "description", 700);
        Item item8;// = new Item("item8", "description", 800);
        Item item9;// = new Item("item9", "description", 900);

        Cart cart1;// = new Cart("customer1", new Date());
        Cart cart2;// = new Cart("customer2", new Date());
        Cart cart3;// = new Cart("customer3", new Date());
        Cart cart4;// = new Cart("customer4", new Date());
        Cart cart5;// = new Cart("customer5", new Date());
        Cart cart6;// = new Cart("customer6", new Date());
        Cart cart7;// = new Cart("customer7", new Date());
        Cart cart8;// = new Cart("customer8", new Date());
        Cart cart9;// = new Cart("customer9", new Date());
        Cart cart10;// = new Cart("customer10", new Date());
        Cart cart11;// = new Cart("customer11", new Date());
        Cart cart12;// = new Cart("customer12", new Date());
        Cart cart13;// = new Cart("customer13", new Date());
        Cart cart14;// = new Cart("customer14", new Date());
        Cart cart15;// = new Cart("customer15", new Date());


        main = new Category("main", null);
        submain = new Category("submain", main);
        subsubmain = new Category("subsubmain", submain);

        main.getSubcategories().add(submain);
        submain.getSubcategories().add(subsubmain);

        main.save();
        submain.save();
        subsubmain.save();

        item1 = new Item("item1", "description", 100);
        item2 = new Item("item2", "description", 200);
        item3 = new Item("item3", "description", 300);
        item4 = new Item("item4", "description", 400);
        item5 = new Item("item5", "description", 500);
        item6 = new Item("item6", "description", 600);
        item7 = new Item("item7", "description", 700);
        item8 = new Item("item8", "description", 800);
        item9 = new Item("item9", "description", 900);

        item1.getCategories().add(main);
        item2.getCategories().add(main);
        item3.getCategories().add(main);

        item4.getCategories().add(submain);
        item5.getCategories().add(submain);
        item6.getCategories().add(submain);

        item7.getCategories().add(subsubmain);
        item8.getCategories().add(subsubmain);
        item9.getCategories().add(subsubmain);

        item1.save();
        item2.save();
        item3.save();
        item4.save();
        item5.save();
        item6.save();
        item7.save();
        item8.save();
        item9.save();


        cart1 = new Cart("customer1", new Date(1420913410));
        cart2 = new Cart("customer2", new Date(1420913410));
        cart3 = new Cart("customer3", new Date(1420913410));
        cart4 = new Cart("customer4", new Date(1420913410));
        cart5 = new Cart("customer5", new Date(1420913410));
        cart6 = new Cart("customer6", new Date(1420913410));
        cart7 = new Cart("customer7", new Date(1420913410));
        cart8 = new Cart("customer8", new Date(1420913410));
        cart9 = new Cart("customer9", new Date(1420913410));
        cart10 = new Cart("customer10", new Date(1420913410));
        cart11 = new Cart("customer11", new Date(1420913410));
        cart12 = new Cart("customer12", new Date(1420913410));
        cart13 = new Cart("customer13", new Date(1420913410));
        cart14 = new Cart("customer14", new Date(1420913410));
        cart15 = new Cart("customer15", new Date(1420913410));

        cart1.addItem(item1, 5);
        cart1.addItem(item2, 10);

        cart2.addItem(item1, 5);
        cart2.addItem(item3, 2);

        cart3.addItem(item1, 1);
        cart3.addItem(item5, 10);

        cart4.addItem(item5, 5);
        cart4.addItem(item6, 3);

        cart5.addItem(item7, 3);
        cart5.addItem(item7, 5);
        cart5.addItem(item8, 9);

        cart6.addItem(item5, 5);
        cart6.addItem(item8, 4);
        cart6.addItem(item9, 8);

        cart7.addItem(item9, 5);
        cart7.addItem(item6, 1);
        cart7.addItem(item5, 1);

        cart8.addItem(item7, 5);
        cart8.addItem(item8, 1);

        cart9.addItem(item1, 1);
        cart9.addItem(item2, 1);
        cart9.addItem(item3, 1);

        cart10.addItem(item8, 1);
        cart10.addItem(item2, 3);
        cart10.addItem(item3, 1);

        cart11.addItem(item1, 1);
        cart11.addItem(item2, 2);
        cart11.addItem(item3, 1);

        cart12.addItem(item1, 1);
        cart12.addItem(item7, 10);
        cart12.addItem(item8, 1);

        cart13.addItem(item9, 4);
        cart13.addItem(item2, 1);
        cart13.addItem(item4, 1);

        cart14.addItem(item1, 1);
        cart14.addItem(item4, 7);

        cart15.addItem(item4, 1);
        cart15.addItem(item7, 3);
        cart15.addItem(item8, 1);

        cart1.save();
        cart2.save();
        cart3.save();
        cart4.save();
        cart5.save();
        cart6.save();
        cart7.save();
        cart8.save();
        cart9.save();
        cart10.save();
        cart11.save();
        cart12.save();
        cart13.save();
        cart14.save();
        cart15.save();
        */


        ItemDAO itemDAO = daof.getItemDaoImpl();

        Set<Item> itemSet = itemDAO.getAll();


        if (session().containsKey("username")) {
            return ok(index.render(title, session().get("username"), itemSet));
        }
        session("username", "Guest User");
        Logger.debug("User: " + session().get("username"));

        return ok(index.render(title, session().get("username"), itemSet));
    }

    public static Result login() {

        return ok(login.render(title, session("username")));
    }

    public static Result doLogin() {

        Form<Login> loginForm = Form.form(Login.class).bindFromRequest(new String[0]);
        if (loginForm.hasErrors()) {
            return badRequest(login.render(title, session().get("username")));
        }

        session().clear();
        session("username", loginForm.get().getName());

        return redirect(routes.Application.index());
    }

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.Application.index());
    }

    public static class Login {
        public String name;

        public String validate() {
            return null;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }


}
