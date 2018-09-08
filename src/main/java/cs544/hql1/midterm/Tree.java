package cs544.hql1.midterm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: franc
 * Date: 07/09/2018
 * Time: 8:36
 */

@Entity(name="Plant")
@DiscriminatorColumn(name = "Ttype")
public class Tree {
    @Id
    @GeneratedValue
    private int id;
    private int height;
    private double price;
    @OneToMany(mappedBy = "tree")
    private List<Treatment> treatments =              new ArrayList<Treatment>();


    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", height=" + height +
                ", price=" + price +
                ", treatments=" + treatments +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public void addTreatment(Treatment treatment) {
        treatment.setTree(this);
        this.treatments.add(treatment);
    }

    public Tree() {
    }
}
