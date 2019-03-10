package com.example.huawei.huaweiapi.converter;

import com.example.huawei.huaweiapi.command.UsersDetailCommand;
import com.example.huawei.huaweiapi.domain.UsersDetail;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersDetailToUsersDetailCommandConverter implements Converter<UsersDetail,UsersDetailCommand> {

    @Override
    public UsersDetailCommand convert(UsersDetail usersDetail) {
        if(usersDetail == null)
            return null;

        UsersDetailCommand usersDetailCommand = new UsersDetailCommand();

        usersDetailCommand.setId(usersDetail.getId());
        usersDetailCommand.setEmail(usersDetail.getEmail());
        usersDetailCommand.setLastName(usersDetail.getLastName());
        usersDetailCommand.setFirstName(usersDetail.getFirstName());

        return usersDetailCommand;

    }
}