package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq_gen")
    @SequenceGenerator(
            name = "persona_seq_gen",
            sequenceName = "persona_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "personal_phone")
    private String personalPhone;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
