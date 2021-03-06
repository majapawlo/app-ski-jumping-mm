package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "country")
public class Hill {

    @Id
    @GeneratedValue
    private Long id;
    //id, name, nation, city, hs_point, ks_point, records(length, date, jumper)
    private String name;

    private Country country;

    private String city;

    @Column(name = "hs_point")
    private int hsPoint;

    @Column(name = "ks_point")
    private int ksPoint;

}
