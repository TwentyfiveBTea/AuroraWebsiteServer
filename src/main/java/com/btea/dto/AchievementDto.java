package com.btea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 13:39
 * @Description: “成就” 数据传送对象实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementDto {
    // 组别
    private String team;

    // 主题
    private String topic;

    // 概要
    private String synopsis;

    // 图片地址一
    private String pictureOne;

    // 图片地址二
    private String pictureTwo;
}
