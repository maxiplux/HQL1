package cs544.hql1.midterm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: franc
 * Date: 07/09/2018
 * Time: 8:36
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;     private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private CreditCard cc;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Tree> trees =  new ArrayList<>();

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

    public CreditCard getCc() {
        return cc;
    }

    public void setCc(CreditCard cc) {
        cc.setCustomer(this);
        this.cc = cc;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void addTree(Tree tree) {
        this.trees.add(tree);
    }

    public Customer() {
    }
}
