package com.btea.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 16:17
 * @Description: 成就实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    // 数据库中主键自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("组别")
    private String team;

    @ApiModelProperty("主题")
    private String topic;

    @ApiModelProperty("概要")
    private String synopsis;

    @ApiModelProperty("图片地址一")
    private String pictureOne;

    @ApiModelProperty("图片地址二")
    private String pictureTwo;
}
