package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.RoleCommand;
import com.example.huawei.huaweiapi.domain.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleCommandConverter implements Converter<Role, RoleCommand> {


    @Override
    public RoleCommand convert(Role role) {
        if(role == null)
            return null;

        RoleCommand roleCommand = new RoleCommand();
        roleCommand.setId(role.getId());
        roleCommand.setRole(role.getRole());

        return roleCommand;
    }
}
