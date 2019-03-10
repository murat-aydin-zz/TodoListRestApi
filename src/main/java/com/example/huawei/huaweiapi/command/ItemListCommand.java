package com.example.huawei.huaweiapi.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt","updateAt"},allowGetters = true)
public class ItemListCommand {

    private Long id;

    private String name;

    private Long userId;

    private Date createdAt;
    private Date updatedAt;


}
