package controller;

import dao.CountryDao;
import dao.CountryDaoImpl;
import lombok.AllArgsConstructor;
import model.Country;
import model.Jumper;
import model.Team;
import service.CoachService;
import service.CountryService;
import service.JumperService;
import service.TeamService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@AllArgsConstructor
public class ConsoleController {

    private CoachService coachService;
    private CountryService countryService;
    private JumperService jumperService;
    private TeamService teamService;



    public void saveJumper(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth(yyyyMMdd): ");
        String dateOfBirth = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDateOfBirth = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        System.out.print("Enter date of debut(yyyyMMdd): ");
        String dateOfDebut = scanner.nextLine();
        LocalDate parsedDateOfDebut = LocalDate.parse(dateOfDebut, dateTimeFormatter);
        System.out.print("Enter height: ");
        int height = scanner.nextInt();
        System.out.print("Enter weight: ");
        int weight = scanner.nextInt();
        System.out.print("Enter team id: ");
        long teamId = scanner.nextLong();
        Team team = teamService.findTeam(teamId);
        System.out.print("Enter country id: ");
        long countryId = scanner.nextLong();
        Country country = countryService.findCountry(countryId);
        System.out.print("Enter wins of world cup: ");
        int wins = scanner.nextInt();
        System.out.print("Set active(y/n): ");
        boolean isActive = false;
        String active = scanner.next();
        if (active.equalsIgnoreCase("y")){
            isActive = true;
        }
        Jumper jumper = Jumper.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(parsedDateOfBirth)
                .debutDate(parsedDateOfDebut)
                .height(height)
                .weight(weight)
                .winsOfWorldCup(wins)
                .isActive(isActive)
                .team(team)
                .country(country)
                .build();
        jumperService.saveJumper(jumper);
    }


}
