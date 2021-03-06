package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
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
    private Team team;
    private int winsOfWorldCup;
    private boolean isActive;




}
