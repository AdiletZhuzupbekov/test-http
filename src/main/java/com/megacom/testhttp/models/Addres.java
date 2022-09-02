package com.megacom.testhttp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Addres {
    @Id
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @ManyToOne
    @JoinColumn(name = "geo_id")
    private Geo geo;
}
