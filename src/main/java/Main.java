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

        JumperDao jumperDao = new JumperDaoImpl(factory);
        JumperService jumperService = new JumperService(jumperDao);
        CountryDao countryDao = new CountryDaoImpl(factory);
        CountryService countryService = new CountryService(countryDao);
        CoachDao coachDao = new CoachDaoImpl(factory);
        CoachService coachService = new CoachService(coachDao);
        TeamDao teamDao = new TeamDaoImpl(factory);
        TeamService teamService = new TeamService(teamDao);

        Country country = Country.builder()
                .continent("Europe")
                .name("Poland")
                .population(38386000)
                .surfaceArea(312696)
                .isoCode("PL")
                .build();

        countryService.saveCountry(country);

        Team team = Team.builder()
                .country(country)
                .name("Team Poland")
                .build();

        teamService.saveTeam(team);

        Jumper jumper1 = Jumper.builder()
                .firstName("Adam")
                .lastName("Małysz")
                .country(country)
                .build();

        jumperService.saveJumper(jumper1);

        Coach coach = Coach.builder()
                .firstName("Michal")
                .lastName("Dolezal")
                .country(country)
                .team(team)
                .build();

        coachService.saveCoach(coach);





    }
}
