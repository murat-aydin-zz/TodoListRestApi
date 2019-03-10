package com.example.huawei.huaweiapi.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDetailCommand {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}