package cs544.hql1.midterm;

import javax.persistence.*;
import java.util.Date;

/**
 * User: franc
 * Date: 07/09/2018
 * Time: 8:36
 */
@Entity
public class Treatment {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tree tree;


    public Treatment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
