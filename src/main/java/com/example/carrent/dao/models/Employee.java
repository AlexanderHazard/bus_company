package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(
            name = "employee_seq_gen",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", insertable = true, updatable = true)
    private Persona persona;

    @Column(name = "category_id")
    private Integer categotyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private DriverCategory driverCategory;

    @Column(name = "position_id")
    private Integer positionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private Position position;

    @Column(name = "bus_id")
    private Integer busId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id", insertable = false, updatable = false)
    private Bus bus;

    @Column(name = "job_start_date")
    private LocalDate jobStart;

    @Column(name = "salary")
    private Integer salary;

}
