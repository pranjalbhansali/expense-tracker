package com.example.codeengine.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String email;

    private String userName;

    private String password;

    private String contact;

    public enum Gender { MALE, FEMALE, OTHER }
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
