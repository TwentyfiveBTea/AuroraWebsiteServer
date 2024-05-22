package com.btea.controller;

import com.btea.dto.AdministratorDto;
import com.btea.result.R;
import com.btea.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 18:55
 * @Description: 登录控制层
 */
@RestController
public class LoginController {
    @Autowired
    private AuthService authService;

    @ApiOperation("管理员登录接口")
    @PostMapping("/settings/login")
    public R login(@RequestParam("account") String account, @RequestParam("password") String password, HttpSession session) {
        AdministratorDto administratorDto = authService.selectAchievementByAccount(account);
        // 如果账号出错
        if (administratorDto == null) {
            return R.noFindUser();
        }

        // 如果密码有误
        if (!password.equals(administratorDto.getPassword())) {
            return R.noFindUser();
        }

        // 如果都没错
        session.setAttribute("loginUser", account);
        return R.ok();

    }
}
