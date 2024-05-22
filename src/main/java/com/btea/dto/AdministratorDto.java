package com.btea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 17:18
 * @Description: Administrator数据传输实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorDto {
    // 账号
    private String account;

    // 密码
    private String password;
}
