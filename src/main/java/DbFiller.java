import dao.*;
import model.Coach;
import model.Country;
import model.Jumper;
import model.Team;
import service.CoachService;
import service.CountryService;
import service.JumperService;
import service.TeamService;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

public class DbFiller {

    public static void fillDb(JumperService jumperService, CountryService countryService, CoachService coachService, TeamService teamService){

        Country countryAut = Country.builder()
                .continent("Europe")
                .name("Austria")
                .population(8859992)
                .surfaceArea(83878)
                .isoCode("AUT")
                .build();

        Country countryPol = Country.builder()
                .continent("Europe")
                .name("Poland")
                .population(38386000)
                .surfaceArea(312696)
                .isoCode("PL")
                .build();


        countryService.saveCountry(countryPol);
        countryService.saveCountry(countryAut);

        Team teamPoland = Team.builder()
                .country(countryPol)
                .name("Team Poland")
                .build();

        Team teamAustria = Team.builder()
                .country(countryAut)
                .name("Team Austria")
                .build();


        teamService.saveTeam(teamPoland);
        teamService.saveTeam(teamAustria);

        Jumper jumper1 = Jumper.builder()
                .firstName("Kamil")
                .lastName("Stoch")
                .dateOfBirth(LocalDate.of(1987,05,25))
                .country(countryPol)
                .team(teamPoland)
                .isActive(true)
                .debutDate(LocalDate.of(2004,01,17))
                .build();

        Jumper jumper2 = Jumper.builder()
                .firstName("Stefan")
                .lastName("Kraft")
                .dateOfBirth(LocalDate.of(1993,05,13))
                .country(countryAut)
                .team(teamAustria)
                .isActive(true)
                .debutDate(LocalDate.of(2012,01,06))
                .build();

        jumperService.saveJumper(jumper1);
        jumperService.saveJumper(jumper2);


        Coach coach1 = Coach.builder()
                .firstName("Michal")
                .lastName("Dolezal")
                .dateOfBirth(LocalDate.of(1978,03,11))
                .country(countryPol)
                .team(teamPoland)
                .build();

        Coach coach2 = Coach.builder()
                .firstName("Andreas")
                .lastName("Widhoelzl")
                .dateOfBirth(LocalDate.of(1976,10,14))
                .country(countryAut)
                .team(teamAustria)
                .build();

        coachService.saveCoach(coach1);
        coachService.saveCoach(coach2);

    }
}
