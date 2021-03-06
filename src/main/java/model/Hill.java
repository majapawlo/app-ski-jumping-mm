package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"country", "competition"})
@ToString(exclude = {"country", "competition"})
public class Hill {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Country country;

    private String city;

    @OneToMany(mappedBy = "hill")
    private Competition competition;

    @Column(name = "hs_point")
    private int hsPoint;

    @Column(name = "ks_point")
    private int ksPoint;

}
