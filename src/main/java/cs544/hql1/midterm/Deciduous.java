package cs544.hql1.midterm;

import javax.persistence.Entity;

/**
 * User: franc
 * Date: 07/09/2018
 * Time: 8:37
 */

@Entity
public class Deciduous extends  Tree {

    private int leafSize;

    public int getLeafSize() {
        return leafSize;
    }

    public void setLeafSize(int leafSize) {
        this.leafSize = leafSize;
    }

    public Deciduous() {
    }
}
