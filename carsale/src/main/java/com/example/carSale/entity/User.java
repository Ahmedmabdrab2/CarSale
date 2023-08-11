package com.example.carSale.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message =  "username cannot be blank")
    @NonNull
    @Column (nullable = false)
    private String username;
    @NotBlank(message =  "password cannot be blank")
    @NonNull
    @Column (nullable = false)
    private String password;
    @Email
    @NotBlank(message =  "email cannot be blank")
    @NonNull
    @Column (nullable = false)
    private String email;
}
