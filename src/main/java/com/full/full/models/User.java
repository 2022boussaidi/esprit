package com.full.full.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name ;
    private String email ;

}
