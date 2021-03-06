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
@EqualsAndHashCode(exclude = {"country", "hill"})
@ToString(exclude = {"country", "hill"})
public class Competition {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Country country;

    private int year;

    @ManyToOne
    private Hill hill;

    private boolean isFinished;
}
