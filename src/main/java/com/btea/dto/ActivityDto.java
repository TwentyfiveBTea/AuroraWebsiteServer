package com.btea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/21 20:19
 * @Description: “展现团建风采” 数据传送对象实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {
    // 主题
    private String theme;

    // 时间
    private String time;

    // 介绍
    private String describes;

    // 图片地址一
    private String pictureOne;

    // 图片地址二
    private String pictureTwo;

    // 图片地址三
    private String pictureThree;
}
