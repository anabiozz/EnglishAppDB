import model.EnglishApp1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.*;

public class FileWorker {
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> listP = new ArrayList<>();
    protected static Map<String, String> map;
    protected static Map<String, String> mapP;
    protected static List<EnglishApp1> book;
    protected static List<EnglishApp1> book2;

    public void ip() {

    }

    //read data from the ForeignWords file
    public static void read() {
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        book =  session.createQuery("SELECT English_Word from model.EnglishApp1").list();
        Iterator it = book.iterator();
        while (it.hasNext()) {
            String result = String.valueOf(it.next());
            list.add(result);
        }
        //Commit transaction
        session.getTransaction().commit();

    }
    //read data from the NativWords file
    public static void readP() {
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        book2 =  session.createQuery("SELECT Russian_Word from model.EnglishApp1").list();
        Iterator it = book2.iterator();
        while (it.hasNext()) {
            String result2 = String.valueOf(it.next());
            listP.add(result2);
        }
        //Commit transaction
        session.getTransaction().commit();
    }

    //write data from ArrayList to HashMap
    //Hashmap used for data transfer.
    public static void log() {
        map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            String q = list.get(i);
            String w = listP.get(i);
            map.put(q, w);
        }
        mapP = new HashMap<>();

        for (int i = 0; i < listP.size(); ++i) {
            String e = listP.get(i);
            String r = list.get(i);
            mapP.put(e, r);
        }
    }

    //write data to files
    public static void writer() {
        EnglishApp1 emp = new EnglishApp1();
        emp.setEnglish_Word(AddWords.addArray);
        emp.setRussian_Word(AddWords.addArray2);
        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Line created: "+emp.getId());
    }

}