package com.btea.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btea.dto.AdministratorDto;
import com.btea.mapper.AdministratorMapper;
import com.btea.pojo.Administrator;
import com.btea.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 17:12
 * @Description: 拦截器接口实现类
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public AdministratorDto selectAchievementByAccount(String account) {
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("password").eq("account", account);
        Administrator administrator = administratorMapper.selectOne(queryWrapper);

        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.setAccount(administrator.getAccount());
        administratorDto.setPassword(administrator.getPassword());

        return administratorDto;
    }
}
