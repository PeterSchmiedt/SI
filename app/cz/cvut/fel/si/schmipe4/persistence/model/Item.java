package cz.cvut.fel.si.schmipe4.persistence.model;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private double price;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;

    public static final Finder<Integer, Item> finder = new Model.Finder<Integer, Item>(Integer.class, Item.class);


    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = new HashSet<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
