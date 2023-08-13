package com.leo.mybatisplus.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Xiexingxie
 * @date 2023/4/23 下午 06:31
 */

@Data
public class PeopleVO  implements Serializable {
    private Integer userId;
    private String userName;
    private String name;
    private Integer departmentId;
    private String position;
    private String email;
    private String phone;
    private String isAdmin;

}
