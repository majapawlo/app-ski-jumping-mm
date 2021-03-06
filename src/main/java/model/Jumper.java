package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //tu dodać klasę Country jako pole
    //tu dodać klasę Team jako pole
    private int winsOfWorldCup;
    private boolean isActive;




}
