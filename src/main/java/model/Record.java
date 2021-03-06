package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"hill","jumper"})
@ToString(exclude = {"hill","jumper"})
@Builder
@AllArgsConstructor
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
