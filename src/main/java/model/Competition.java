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
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"country", "hill", "jumps"})
@ToString(exclude = {"country", "hill", "jumps"})
public class Competition {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Country country;

    private String season;

    @ManyToOne
    private Hill hill;

    @OneToMany(mappedBy = "competition")
    private Set<Jumps> jumps = new HashSet<>();

    private boolean isFinished;
}
