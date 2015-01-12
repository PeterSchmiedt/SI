package cz.cvut.fel.si.schmipe4.persistence.model;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class CartItem extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    private int quantity;

    public static final Finder<Integer, CartItem> finder = new Model.Finder<Integer, CartItem>(Integer.class, CartItem.class);


    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
