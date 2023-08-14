package com.exemple1.demoMVC.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long Id;
    @NotBlank
    @Size(min=4,max=20)
    private String name;

    @Max(1100)
    private int score;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;
}
