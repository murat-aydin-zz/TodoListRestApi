package com.example.huawei.huaweiapi.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ItemCommand {

    private Long id;

    private String name;

    private String description;

    private Boolean status;

    private Date deadline;

    private Long itemListId;
}
