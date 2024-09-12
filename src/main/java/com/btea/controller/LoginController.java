package com.btea.controller;

import com.btea.dto.AdministratorDto;
import com.btea.result.R;
import com.btea.service.AuthService;
import com.btea.utils.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 18:55
 * @Description: 登录控制层
 */
@CrossOrigin
@RestController
public class LoginController {
//    @Autowired
//    private AuthService authService;
//
//    @ApiOperation("管理员登录接口")
//    @PostMapping("/settings/login")
//    public R login(@RequestParam("account") String account, @RequestParam("password") String password) {
//        AdministratorDto administratorDto = authService.selectAchievementByAccount(account);
//        // 如果账号出错
//        if (administratorDto == null) {
//            return R.noFindUser();
//        }
//
//        // 如果密码有误
//        if (!password.equals(administratorDto.getPassword())) {
//            return R.noFindUser();
//        }
//
//        // 如果都没错，生成 Token (用户名 + 当前时间戳(秒级) )
//        TokenUtil tokenUtil = new TokenUtil();
//        String token = tokenUtil.createToken(account);
//
//        return R.token(token);
//    }
}
