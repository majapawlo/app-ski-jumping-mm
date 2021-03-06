package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"jumpers", "coach", "country"})
@ToString(exclude = {"jumpers", "coach", "country"})
@Builder
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Country country;

    @OneToMany(mappedBy = "team")
    @Builder.Default
    private Set<Jumper> jumpers = new HashSet<>();

    @OneToOne(mappedBy = "team")
    private Coach coach;

    public void addJumper(Jumper jumper){
        jumpers.add(jumper);
        jumper.setTeam(this);
    }
}
