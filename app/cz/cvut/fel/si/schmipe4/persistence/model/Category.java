package cz.cvut.fel.si.schmipe4.persistence.model;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //TODO aby sme zabezpecili ze sa kategorie nebudu opakovat .... dame ID nazov ...
    private String name;

    @OneToMany(mappedBy = "parent")
    private Set<Category> subcategories;

    @ManyToOne
    private Category parent;


    public static Finder<Integer, Category> finder = new Model.Finder<Integer, Category>(Integer.class, Category.class);


    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
        this.subcategories = new HashSet<>();
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

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
