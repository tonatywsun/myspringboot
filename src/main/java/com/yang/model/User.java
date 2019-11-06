package com.yang.model;

import com.yang.validator.UserIdentity;
import com.yang.validator.ValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
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
public class User implements Serializable {
    @ApiModelProperty(value = "主键ID", name = "id")
    private Long id;
    @ApiModelProperty(value = "会员号", name = "uNo")
    private Long uNo;
    @ApiModelProperty(value = "会员身份", name = "uIdentity")
    @UserIdentity(groups = {ValidGroup.AddValid.class})
    private Byte uIdentity;
    @ApiModelProperty(value = "会员状态", name = "uStatus")
    private Byte uStatus;
    @ApiModelProperty(value = "会员名称", name = "uName")
    private String uName;
    @ApiModelProperty(value = "会员性别", name = "uSex")
    private Byte uSex;
    @ApiModelProperty(value = "会员年龄", name = "uAge")
    private Short uAge;
    @ApiModelProperty(value = "会员生日", name = "uBirthday")
    private LocalDate uBirthday;
    //这个设置为Date是为了分别验证Date LocalDateTime LocalDate返回值字符串格式
    private Date updateDatetime;

    private LocalDateTime createDatetime;
}
