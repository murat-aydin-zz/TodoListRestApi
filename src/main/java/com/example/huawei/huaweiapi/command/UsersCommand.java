package com.example.huawei.huaweiapi.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UsersCommand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String password;

    private String userName;

    private int active;

    private UsersDetailCommand usersDetail;

    private Set<RoleCommand> roles = new HashSet<>();

    public UsersCommand(UsersCommand usersCommand) {
        this.id = usersCommand.getId();
        this.password = usersCommand.getPassword();
        this.userName = usersCommand.getUserName();
        this.active = usersCommand.getActive();
        this.usersDetail = usersCommand.getUsersDetail();
        this.roles = usersCommand.getRoles();
    }
}