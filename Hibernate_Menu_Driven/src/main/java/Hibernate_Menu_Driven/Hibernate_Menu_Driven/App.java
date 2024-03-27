package Hibernate_Menu_Driven.Hibernate_Menu_Driven;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	int y;
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	SessionFactory sf = cfg.buildSessionFactory();
    	 Scanner ip = new Scanner(System.in);
    	do {
    		
    	try
    	{    	
    	
        System.out.println("******* MENU *******");
        System.out.println("Press 1 to Insert Data");
        System.out.println("Press 2 to Retrive Data");
        System.out.println("Press 3 to Update Data");
        System.out.println("Press 4 to Delete Data");
        System.out.println("Press 5 to Exit ");
        System.out.println();
        System.out.println("Enter Choice :");
       
        
        int ch = ip.nextInt();
        
        
        switch(ch)
        {
        case 1:
        	 Session s = sf.openSession();
             System.out.println("Enter Enrollment Number :");
             int enroll = ip.nextInt();
             System.out.println("Enter Student Name :");
             String name = ip.next();
             System.out.println("Enter Percentage :");
             Float per = ip.nextFloat();
             Acropolis a = new Acropolis();
             a.setEnroll(enroll);
             a.setName(name);
             a.setPer(per);
             Transaction tx = s.beginTransaction();
             s.save(a);
             tx.commit();
             s.close();
             System.out.println();
             System.out.println("Data Inserted !");
             break;
        	
        case 2:
        	Session s1 = sf.openSession();
            System.out.println("Enter Enrollment Number :");
            int enrol = ip.nextInt();
            Acropolis a1 = (Acropolis)s1.get(Acropolis.class, enrol);
            System.out.println();
            System.out.println("Student Name : "+a1.getName());
            System.out.println("Percentage : "+a1.getPer());
            break;
            
        case 3:
        	System.out.println("Enter Enrollment Number :");
            int roll = ip.nextInt();
            
            System.out.println("Press 1 to Update Name");
            System.out.println("Press 2 to Update Percent");
            
            int c =ip.nextInt();
            Session su = sf.openSession();
            Transaction t =su.beginTransaction();
            switch(c) {
            
            case 1 :
            	System.out.println("Enter new Student name :");
                String na = ip.next();
            	Acropolis aa = (Acropolis)su.get(Acropolis.class, roll);
            	aa.setName(na);
            	su.update(aa);
            	t.commit();
            	su.close();
            	
            	break;
            case 2:
            	System.out.println("Enter new Student percentage :");
                Float pe = ip.nextFloat();
            	Acropolis au = (Acropolis)su.get(Acropolis.class, roll);
            	au.setPer(pe);
            	su.update(au);
            	t.commit();
            	su.close();
            	
            	break;
            }
            System.out.println("Data Updated !");
            
            break;
            
        case 4: 
        	System.out.println("Enter Enrollment Number :");
            int ro = ip.nextInt();
            Session s2 = sf.openSession();
            Transaction tt = s2.beginTransaction();
            Acropolis ob = (Acropolis)s2.get(Acropolis.class, ro);
            s2.delete(ob);
            tt.commit();
            s2.close();
            System.out.println("Data Deleted !");
            break;
            
        case 5:
        	System.out.println("Thank You for Using My Software !");
        	System.exit(0);
        	break;
        	
        default : 
        	System.out.println("Invalid Choice ");
        	break;
        }
        
    	}
    	 catch (InputMismatchException e) {
             System.out.println("Invalid input. Please give a valid input`");
            
             ip.next();
    	 }
    	catch(Throwable e) {
    		
    		System.out.println("Something went wrong ! ");
    		System.out.println(e.getMessage());
    	}
        
        
        
        
        System.out.println();
        System.out.println("Press 1 to Continue and 0 to exit......"); 
        y=ip.nextInt();
        
        
    	}while(y==1);
    	
             
    	ip.close();
    	
    	
    }
}
