package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Jumps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //dodać pole Jumper
    private double firstRoundLength;
    private double firstRoundNote;
    private double firstRoundWindPoints;
    private double secondRoundLength;
    private double secondRoundNote;
    private double secondRoundWindPoints;
    //dodać pole Competition
    private int positionInWorldCup;



}
