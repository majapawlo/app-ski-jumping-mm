package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"jumpers", "coaches", "country"})
@ToString(exclude = {"jumpers", "coaches", "country"})
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Country country;

    @OneToMany(mappedBy = "team")
    private Set<Jumper> jumpers = new HashSet<>();

    @OneToOne(mappedBy = "team")
    private Set<Coach> coaches = new HashSet<>();
}
