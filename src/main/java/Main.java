import dao.JumperDao;
import dao.JumperDaoImpl;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure().buildSessionFactory();

        JumperDao jumperDao = new JumperDaoImpl(factory);


    }
}
