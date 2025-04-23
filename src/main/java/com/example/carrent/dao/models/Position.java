package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "position")
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position_name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private List<Employee> employees;

}
