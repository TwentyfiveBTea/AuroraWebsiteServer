package com.btea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 18:40
 * @Description: “加入我们” 数据传送对象实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {
    // 姓名
    private String name;

    // 性别
    private String gender;

    // 年级
    private String grade;

    // 电话
    private String phone;

    // 邮箱
    private String email;

    // 专业
    private String majors;

    // 方向
    private String orientation;

    // 介绍
    private String introduce;
}
