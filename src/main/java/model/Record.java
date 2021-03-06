package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"hill","jumper"})
@ToString(exclude = {"hill","jumper"})
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private double length;
    private LocalDate dateOdEnd;
    @ManyToOne
    private Jumper jumper;
    @ManyToOne
    private Hill hill;



}
