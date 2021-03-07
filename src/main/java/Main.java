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
