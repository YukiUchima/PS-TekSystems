package glab30552b;

import glab30552b.model.Address;
import glab30552b.model.Cohort;
import glab30552b.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

//Guided LAB - 305.5.2B - Demonstration of OneToOne Relationship and Mapping with IntelliJ Ultimate
public class Main {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("usersdb.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        try {
            oneToOne(session);
            manyToMany(session);

        } catch (SessionException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
    }


    private static void manyToMany(Session session) {
        Transaction t = session.beginTransaction();
        try{
            //----Create Cohort/class Entity set one----
            Cohort Class1 = new Cohort("Java Developer", "14 weeks");
            Cohort Class2 = new Cohort("FullStack Developer", "7 Weeks");
            Cohort Class3 = new Cohort("Python Developer", "12 Weeks");

            //------  Store Cohort  / Class  --------
            session.persist(Class1);
            session.persist(Class2);
            session.persist(Class3);

            //-----Create Cohort one / Class one --------
            Set<Cohort> ClassSet1 = new HashSet<Cohort>();
            ClassSet1.add(Class1);
            ClassSet1.add(Class2);
            ClassSet1.add(Class3);

            //-----Create Cohort two / Class two --------
            Set<Cohort> ClassSet2 = new HashSet<Cohort>();
            ClassSet2.add(Class2);
            ClassSet2.add(Class3);
            ClassSet2.add(Class1);

            //-----Create Cohort Three / Class Three --------
            Set<Cohort> ClassSet3 = new HashSet<Cohort>();
            ClassSet3.add(Class3);
            ClassSet3.add(Class1);
            ClassSet3.add(Class2);

            Teacher t1 = new Teacher("100", "Haseeb", ClassSet1);
            Teacher t2 = new Teacher("200", "Jenny", ClassSet2);
            Teacher t3 = new Teacher("200", "Charlie", ClassSet3);

            session.persist(t1);
            session.persist(t2);
            session.persist(t3);
            t.commit();

        }catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }

    }

    public static void oneToOne(Session session) {
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");
        Transaction t = session.beginTransaction();

        try {
            Address a1 = new Address("27th street", "NYC", "NY", 11103);
            Address a2 = new Address("28th street", "Buffalo", "NY", 15803);

            Teacher t1 = new Teacher("1000", "MHaseeb");
            Teacher t2 = new Teacher("2220", "Shahparan");

            t1.setAddress(a1);
            t2.setAddress(a2);

            session.persist(t1);
            session.persist(t2);
            session.persist(a1);
            session.persist(a2);

            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }
}
