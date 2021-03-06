package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private Country country;

    private int year;

    private Hill hill;

    private boolean isFinished;
}
