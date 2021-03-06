package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"country","team","records","jumps"})
@ToString(exclude ={"country","team","records","jumps"})
public class Jumper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private LocalDate dateOfBirth;
    private LocalDate debutDate;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Team team;
    private int winsOfWorldCup;
    private boolean isActive;
    @OneToMany(mappedBy = "jumper")
    private Set<Record> records = new HashSet<>();
    @OneToMany(mappedBy = "jumper")
    private Set<Jumps> jumps = new HashSet<>();






}
