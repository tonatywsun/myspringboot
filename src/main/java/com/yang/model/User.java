package com.yang.model;

import com.yang.validator.UserIdentity;
import com.yang.validator.ValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 16:56
 */
@Data
@Table(name = "t_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@ApiModel(description = "用户")
public class User {
    @ApiModelProperty(value = "主键ID", name = "id")
    private Long id;
    @ApiModelProperty(value = "会员号", name = "uNo")
    private Long uNo;

    @UserIdentity(groups = {ValidGroup.AddValid.class})
    private Byte uIdentity;

    private Byte uStatus;

    private String uName;

    private Byte uSex;

    private Short uAge;

    private LocalDate uBirthday;
    //这个设置为Date是为了分别验证Date LocalDateTime LocalDate返回值字符串格式
    private Date updateDatetime;

    private LocalDateTime createDatetime;
}
