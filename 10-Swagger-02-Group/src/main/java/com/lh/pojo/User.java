package com.lh.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Api(注释)
@Data
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户id")
    public  Integer id;
    @ApiModelProperty("用户名")
    public  String username;
    @ApiModelProperty("用户密码")
    public  String password;


}
