package com.yang.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 16:56
 */
@Data
@ToString
@Table(name = "t_member_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Member implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "gender")
    private Byte gender;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "union_id")
    private String unionId;
    @Column(name = "check_mobile")
    private Byte checkMobile;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_delete")
    private Byte delete;
    @Column(name = "create_time")
    private LocalDateTime  createTime;
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    List<Card> cards;
}
