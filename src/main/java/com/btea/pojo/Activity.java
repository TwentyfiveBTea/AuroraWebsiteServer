package com.btea.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 16:21
 * @Description: 活动实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    // 数据库中主键自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("主题")
    private String theme;

    @ApiModelProperty("介绍")
    private String describes;

    @ApiModelProperty("时间")
    private String time;

    @ApiModelProperty("图片地址一")
    private String pictureOne;

    @ApiModelProperty("图片地址二")
    private String pictureTwo;

    @ApiModelProperty("图片地址三")
    private String pictureThree;
}
