package cz.cvut.fel.si.schmipe4.persistence.model;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart extends Model {

    @Id
    private String customer;
    private double total;
    private Date date;

    private boolean shop;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> items;

    public static Finder<String, Cart> finder = new Model.Finder<String, Cart>(String.class, Cart.class);


    public Cart(String customer, Date date) {
        this.customer = customer;
        this.total = 0;
        this.date = date;
        this.items = new HashSet<>();
        this.shop = false;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public void addItem(Item item, int quantity) {
        for (CartItem currentCartItem : items) {
            if (currentCartItem.getItem().getId() == item.getId()) {
                currentCartItem.setQuantity(currentCartItem.getQuantity() + quantity); //add only quantity

                //update price
                total += item.getPrice() * quantity;
                return;
            }
        }
        CartItem cartItem = new CartItem(item, quantity);
        items.add(cartItem);
        //update price
        total += item.getPrice() * quantity;
    }
}
