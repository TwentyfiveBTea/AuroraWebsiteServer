package com.btea.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 16:02
 * @Description: 管理员实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    // 数据库中主键自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;
}
