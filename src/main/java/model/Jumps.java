package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"jumper","competition"})
@ToString(exclude = {"jumper","competition"})
public class Jumps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Jumper jumper;
    private double firstRoundLength;
    private double firstRoundNote;
    private double firstRoundWindPoints;
    private double secondRoundLength;
    private double secondRoundNote;
    private double secondRoundWindPoints;
    @ManyToOne
    private Competition competition;
    private int positionInWorldCup;



}
