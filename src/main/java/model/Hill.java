package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"country", "competitions", "records"})
@ToString(exclude = {"country", "competitions", "records"})
@Builder
@AllArgsConstructor
public class Hill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;

    private String city;

    @OneToMany(mappedBy = "hill")
    @Builder.Default
    private Set<Record> records = new HashSet<>();

    @OneToMany(mappedBy = "hill")
    @Builder.Default
    private Set<Competition> competitions = new HashSet<>();

    @Column(name = "hs_point")
    private int hsPoint;

    @Column(name = "ks_point")
    private int ksPoint;

    public void addRecord(Record record){
        records.add(record);
        record.setHill(this);
    }
    public void addCompetition(Competition competition){
        competitions.add(competition);
        competition.setHill(this);
    }
}
