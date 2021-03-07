import dao.*;
import model.Coach;
import model.Country;
import model.Jumper;
import model.Team;
import org.hibernate.cfg.Configuration;
import service.CoachService;
import service.CountryService;
import service.JumperService;
import service.TeamService;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure().buildSessionFactory();

        DbFiller.fillDb(factory);






    }
}
