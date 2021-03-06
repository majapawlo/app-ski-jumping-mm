package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"jumpers", "coaches"})
@ToString(exclude = {"jumpers", "coaches"})
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private Country country;

    private Set<Jumper> jumpers = new HashSet<>();

    //private Set<Coach> coaches = new HashSet<>();
}
