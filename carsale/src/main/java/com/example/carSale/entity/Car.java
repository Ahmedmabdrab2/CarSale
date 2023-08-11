package com.example.carSale.entity;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car", uniqueConstraints={@UniqueConstraint(columnNames = {"type", "mileage"})
})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "typecan not be blank")
    @Column(name = "type",nullable = false)
    private String type;
    @NotBlank(message = "made can not be blank")
    @Column(name = "made", nullable = false)
    private String made;
    @NotBlank( message = "mileage can not be blank")
    @Pattern(message = ("number format should be (00,000.00)"),regexp = "^(\\d{1,3}(,\\d{3})*|\\d+)(\\.\\d+)?$")
    @Column(name = "mileage",nullable = false)
    private String mileage;

}
