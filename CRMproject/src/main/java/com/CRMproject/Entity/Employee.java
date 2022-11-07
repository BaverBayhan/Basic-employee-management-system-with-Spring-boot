package com.CRMproject.Entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="first_name")
    String first_name;
    @Column(name="last_name")
    String last_name;
    @Column(name="e_mail")
    String e_mail;
}
