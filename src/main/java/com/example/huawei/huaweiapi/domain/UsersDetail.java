package com.example.huawei.huaweiapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class UsersDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Users users;
}