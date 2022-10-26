package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private Integer id;        //id
    private Integer ownerid;   //家主编号
    private String housename;  //家庭名称
    private String address;    //家庭地址
    
}
