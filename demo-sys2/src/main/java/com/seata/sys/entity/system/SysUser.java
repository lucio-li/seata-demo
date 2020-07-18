package com.seata.sys.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：SysUser
 * 用户
 */
@Data
@TableName("sys_user")
public class SysUser  {
    @ApiModelProperty(value = " id")
    private String id;
    @ApiModelProperty(value = " 用户实名")
    private String name;
    @ApiModelProperty(value = "提示信息")
    private String msg;


}
