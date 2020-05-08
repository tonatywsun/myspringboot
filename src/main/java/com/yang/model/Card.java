package com.yang.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2020/05/08 11:48
 */
@Data
@ToString
@Table(name = "t_card_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Card {
    @Id
    @Column(name = "card_no", unique = true)
    private Long cardNo;
    @Column(name = "member_id")
    private Long memberId;
}
