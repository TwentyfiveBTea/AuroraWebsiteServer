package com.btea.service;

import com.btea.dto.AdministratorDto;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 17:11
 * @Description: 拦截器接口
 */
public interface AuthService {
    /**
     * 根据账号找到对应管理员
     *
     * @param account
     * @return 管理员的账号和密码
     */
    AdministratorDto selectAchievementByAccount(String account);


}
