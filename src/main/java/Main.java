import controller.ConsoleController;
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
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure().buildSessionFactory();
        JumperDao jumperDao = new JumperDaoImpl(factory);
        JumperService jumperService = new JumperService(jumperDao);
        CountryDao countryDao = new CountryDaoImpl(factory);
        CountryService countryService = new CountryService(countryDao);
        CoachDao coachDao = new CoachDaoImpl(factory);
        CoachService coachService = new CoachService(coachDao);
        TeamDao teamDao = new TeamDaoImpl(factory);
        TeamService teamService = new TeamService(teamDao);

        DbFiller.fillDb(factory);



        for (int i = 0; ; i++){
            System.out.println("nr akcji");
            int number = new Scanner(System.in).nextInt();
            if (number == 1){
                ConsoleController consoleController = new ConsoleController(coachService,countryService,jumperService,teamService);
                consoleController.saveJumper();
            } else if (number == 2) {
                break;
            }
        }



    }
}
