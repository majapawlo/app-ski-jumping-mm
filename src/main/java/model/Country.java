package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"jumpers", "coaches", "hills", "competitions", "team"})
@ToString(exclude = {"jumpers", "coaches", "hills", "competitions", "team"})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "iso_code")
    private String isoCode;

    private String continent;

    @Column(name = "surface_area")
    private int surfaceArea;

    private int population;

    @OneToMany(mappedBy = "country")
    private Set<Jumper> jumpers = new HashSet<>();

    @OneToMany(mappedBy = "country")
    private Set<Coach> coaches = new HashSet<>();

    @OneToMany(mappedBy = "country")
    private Set<Hill> hills = new HashSet<>();

    @OneToMany(mappedBy = "country") //
    private Set<Competition> competitions = new HashSet<>();

    @OneToOne(mappedBy = "country")
    private Team team;

    public void addJumper(Jumper jumper){
        jumpers.add(jumper);
        jumper.setCountry(this);
    }
    public void addCoach(Coach coach){
        coaches.add(coach);
        coach.setCountry(this);
    }
    public void addCompetition(Competition competition){
        competitions.add(competition);
        competition.setCountry(this);
    }
    public void addHill(Hill hill){
        hills.add(hill);
        hill.setCountry(this);
    }

}
