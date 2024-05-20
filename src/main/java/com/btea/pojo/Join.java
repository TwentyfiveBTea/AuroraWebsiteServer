package com.btea.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 16:07
 * @Description: 加入我们实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Join {
    // 数据库中主键自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("专业")
    private String majors;

    @ApiModelProperty("方向")
    private String orientation;

    @ApiModelProperty("介绍")
    private String introduce;

    // 表示 /join 是否开启 -- 0 表关闭，1 表开启
    @ApiModelProperty("状态")
    private Integer state;
}

