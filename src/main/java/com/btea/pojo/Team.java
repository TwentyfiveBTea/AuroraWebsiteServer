package com.btea.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 16:12
 * @Description: 团队实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    // 数据库中主键自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("方向")
    private String orientation;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职位一")
    private String positionOne;

    @ApiModelProperty("职位二")
    private String positionTwo;

    @ApiModelProperty("简介")
    private String word;

    @ApiModelProperty("图片地址")
    private String picture;
}
