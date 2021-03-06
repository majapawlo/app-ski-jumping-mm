package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"country","team","records","jumps"})
@ToString(exclude ={"country","team","records","jumps"})
@Builder
@AllArgsConstructor
public class Jumper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private LocalDate dateOfBirth;
    private LocalDate debutDate;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Team team;
    private int winsOfWorldCup;
    private boolean isActive;
    @OneToMany(mappedBy = "jumper")
    @Builder.Default
    private Set<Record> records = new HashSet<>();
    @OneToMany(mappedBy = "jumper")
    @Builder.Default
    private Set<Jumps> jumps = new HashSet<>();


    public void addRecord(Record record){
        records.add(record);
        record.setJumper(this);
    }
    public void addJump(Jumps jump){
        jumps.add(jump);
        jump.setJumper(this);
    }








}
