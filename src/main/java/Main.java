import dao.JumperDao;
import dao.JumperDaoImpl;
import model.Jumper;
import org.hibernate.cfg.Configuration;
import service.JumperService;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure().buildSessionFactory();

        JumperDao jumperDao = new JumperDaoImpl(factory);
        JumperService jumperService = new JumperService(jumperDao);

        Jumper jumper1 = Jumper.builder().firstName("Adam").lastName("Małysz").build();
        jumperService.saveJumper(jumper1);


    }
}
