package com.leo.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Xiexingxie
 * @date 2023/4/23 下午 05:30
 */

@Data
@TableName("people")
public class PeopleDto implements Serializable {
    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;
    @TableField("userName")
    private String  userName;
    private String password;
    private String name;
    @TableField("departmentId")
    private Integer departmentId;
    private String position;
    private String email;
    private String phone;
    @TableField("isAdmin")
    private String isAdmin;


}
