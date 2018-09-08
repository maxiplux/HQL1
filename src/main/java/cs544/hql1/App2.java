package cs544.hql1;

import cs544.hql1.midterm.CreditCard;
import cs544.hql1.midterm.Customer;
import cs544.hql1.midterm.Treatment;
import cs544.hql1.midterm.Tree;
import cs544.hql1.model.Airline;
import cs544.hql1.model.Airplane;
import cs544.hql1.model.Airport;
import cs544.hql1.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class App2 {

    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) throws Exception {
        setUp();




        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = new Customer();
        CreditCard credicard= new CreditCard();

        credicard.setName("visa");
        credicard.setExpiration(new Date());
        credicard.setNumber(1111);
        customer.setCc(credicard);
        Tree tree= new Tree();
        tree.setHeight(10);
        tree.setPrice(900);
        Treatment treatment = new Treatment();
        treatment.setDate(new Date());
        treatment.setDescription("tree example tratament");

        tree.addTreatment(treatment);
        customer.addTree(tree);

        session.persist(customer);

        System.out.println();
        //session.getTransaction().commit();

       Query  query = session.createQuery("from  Plant ");
       List<Tree> trees =  query.list();
       System.out.println(trees);

        session.close();



        // Close the SessionFactory (best practice)
        //tearDown();
    }


}
