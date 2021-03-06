package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"jumpers", "coaches", "hills", "competitions", "team"})
@ToString(exclude = {"jumpers", "coaches", "hills", "competitions", "team"})
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "iso_code")
    private String isoCode;

    private String continent;

    @Column(name = "surface_area")
    private int surfaceArea;

    private int population;

    private Set<Jumper> jumpers = new HashSet<>();

    //private Set<Coach> coaches = new HashSet<>();

    private Set<Hill> hills = new HashSet<>();

    private Set<Competition> competitions = new HashSet<>();

    private Team team;

}
