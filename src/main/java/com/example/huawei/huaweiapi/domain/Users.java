package com.example.huawei.huaweiapi.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"usersDetail","itemList"})
@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String userName;

    private int active;

    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UsersDetail usersDetail;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ItemList> itemList = new HashSet<>();

  //  @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
   // private Set<Post> postSet = new HashSet<>();





}