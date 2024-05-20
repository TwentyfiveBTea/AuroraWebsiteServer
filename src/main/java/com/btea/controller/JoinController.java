package com.btea.controller;

import com.btea.dto.JoinDto;
import com.btea.result.R;
import com.btea.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 19:23
 * @Description: “加入我们” 控制层
 */
@RestController
public class JoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public R join(@RequestParam("name") String name, @RequestParam("gender") String gender,
                  @RequestParam("grade") String grade, @RequestParam("phone") String phone,
                  @RequestParam("email") String email, @RequestParam("majors") String majors,
                  @RequestParam("orientation") String orientation, @RequestParam("introduce") String introduce) {

        JoinDto joinDto = new JoinDto();
        joinDto.setName(name);
        joinDto.setGender(gender);
        joinDto.setGrade(grade);
        joinDto.setPhone(phone);
        joinDto.setEmail(email);
        joinDto.setMajors(majors);
        joinDto.setOrientation(orientation);
        joinDto.setIntroduce(introduce);

        // 如果年级长度大于三或为 0
        if (joinDto.getGrade().length() > 3 || joinDto.getGrade().isEmpty()) {
            return R.unprocessableEntity("你这年级确定填对了?");
            // 判断手机号格式
        } else if (!joinDto.getPhone().matches("^1[3|4|5|7|8][0-9]{9}$")) {
            return R.unprocessableEntity("你这手机号不对吧...");
            // 判断邮箱格式
        } else if (!joinDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$")) {
            return R.unprocessableEntity("你这邮箱不对吧...");
        }

        int i = joinService.insertMember(joinDto);
        if (i != 1) {
            return R.serverError();
        } else {
            return R.ok();
        }
    }

    @PostMapping("/settings/roster")
    public R roster() {
        String mumber = joinService.selectAllMember();
        return R.ok(mumber);
    }

}
