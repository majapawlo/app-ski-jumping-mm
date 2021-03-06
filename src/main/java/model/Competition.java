package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"country", "hill", "jumps"})
@ToString(exclude = {"country", "hill", "jumps"})
@Builder
@AllArgsConstructor
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Country country;

    private String season;

    @ManyToOne
    private Hill hill;

    @OneToMany(mappedBy = "competition")
    @Builder.Default
    private Set<Jumps> jumps = new HashSet<>();

    private boolean isFinished;

    public void addJumps(Jumps jump){
        jumps.add(jump);
        jump.setCompetition(this);
    }
}
