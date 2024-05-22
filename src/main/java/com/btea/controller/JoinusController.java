package com.btea.controller;

import com.btea.dto.JoinusDto;
import com.btea.result.R;
import com.btea.service.JoinusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 19:23
 * @Description: “加入我们” 控制层
 */
@RestController
public class JoinusController {
    @Autowired
    private JoinusService joinusService;

    @ApiOperation("加入我们接口")
    @PostMapping("/join")
    public R join(@RequestParam("name") String name, @RequestParam("gender") String gender,
                  @RequestParam("grade") String grade, @RequestParam("phone") String phone,
                  @RequestParam("email") String email, @RequestParam("majors") String majors,
                  @RequestParam("orientation") String orientation, @RequestParam("introduce") String introduce) {

        JoinusDto joinusDto = new JoinusDto();
        joinusDto.setName(name);
        joinusDto.setGender(gender);
        joinusDto.setGrade(grade);
        joinusDto.setPhone(phone);
        joinusDto.setEmail(email);
        joinusDto.setMajors(majors);
        joinusDto.setOrientation(orientation);
        joinusDto.setIntroduce(introduce);

        // 如果年级长度大于三或为 0
        if (joinusDto.getGrade().length() > 3 || joinusDto.getGrade().isEmpty()) {
            return R.unprocessableEntity("你这年级确定填对了?");
            // 判断手机号格式
        } else if (!joinusDto.getPhone().matches("^1[3|4|5|7|8][0-9]{9}$")) {
            return R.unprocessableEntity("你这手机号不对吧...");
            // 判断邮箱格式
        } else if (!joinusDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$")) {
            return R.unprocessableEntity("你这邮箱不对吧...");
        }

        int i = joinusService.insertMember(joinusDto);
        if (i == 1) {
            return R.ok();
        } else {
            return R.serverError();
        }
    }

    @ApiOperation("报名情况接口")
    @GetMapping("/settings/roster")
    public R roster(@RequestParam("page") int page, HttpSession session) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.notLoggedIn();
        }
        String member = joinusService.selectPageAllMember(page);
        return R.ok(member);
    }

}
