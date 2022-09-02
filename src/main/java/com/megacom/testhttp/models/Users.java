package com.megacom.testhttp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    private Long id;
    private String name;
    private String username;
    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Addres address;
    private String phone;
    private String website;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
