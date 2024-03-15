package HibernateApplication_1.HibernateApplication_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg =new Configuration();
        cfg.configure();
        
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session sess = sf.openSession();
        
        Student s= new Student();
        s.setRoll(1);
        s.setName("Devansh");
        s.setPercent(95.9f);
        
        Transaction t = sess.beginTransaction();
        
        sess.save(s);
        
        t.commit();
        
        sess.close();
        
        System.out.println("DATA  INSERTED !!");
    }
}
