package com.btea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 15:13
 * @Description: “团队照片” 数据传送对象实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    // 年级
    private String grade;

    // 方向
    private String orientation;

    // 姓名
    private String name;

    // 职位一
    private String positionOne;

    // 职位二
    private String positionTwo;

    // 简介
    private String word;

    // 图片地址
    private String picture;
}
