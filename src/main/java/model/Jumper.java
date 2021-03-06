package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"country","team"})
@ToString(exclude ={"country","team"})
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




}
