CREATE TABLE `t_member_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `mobile_no` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0-女 1-男',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `union_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信union_id',
  `check_mobile` tinyint(1) NULL DEFAULT 0 COMMENT '是否校验手机号 0-no  1-yes',
  `status` smallint(2) NULL DEFAULT 0 COMMENT '会员状态 0 -正常',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0-no 1-yes',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `i_member_info_mobile_no`(`mobile_no`) USING BTREE,
  INDEX `i_member_info_birthday`(`birthday`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000000000 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;