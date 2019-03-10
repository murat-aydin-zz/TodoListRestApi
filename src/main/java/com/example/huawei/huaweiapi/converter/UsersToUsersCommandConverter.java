package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.UsersCommand;
import com.example.huawei.huaweiapi.domain.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersToUsersCommandConverter implements Converter<Users, UsersCommand> {

    UsersDetailToUsersDetailCommandConverter usersDetailToUsersDetailCommandConverter;

    RoleToRoleCommandConverter roleToRoleCommandConverter;

    public UsersToUsersCommandConverter(UsersDetailToUsersDetailCommandConverter usersDetailToUsersDetailCommandConverter, RoleToRoleCommandConverter roleToRoleCommandConverter) {
        this.usersDetailToUsersDetailCommandConverter = usersDetailToUsersDetailCommandConverter;
        this.roleToRoleCommandConverter = roleToRoleCommandConverter;
    }

    @Override
    public UsersCommand convert(Users users) {
        if(users == null)
            return null;

        UsersCommand usersCommand = new UsersCommand();
        usersCommand.setId(users.getId());
        usersCommand.setActive(users.getActive());
        usersCommand.setPassword(users.getPassword());
        usersCommand.setUserName(users.getUserName());

        if(users.getUsersDetail() != null){
            usersCommand.setUsersDetail(usersDetailToUsersDetailCommandConverter.convert(users.getUsersDetail()));
        }

        if(users.getRole() != null && users.getRole().size() > 0){
            users.getRole().forEach(role -> usersCommand.getRoles().add(roleToRoleCommandConverter.convert(role)));
        }

        return usersCommand;

    }
}