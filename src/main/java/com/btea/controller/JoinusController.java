package com.btea.controller;

import com.btea.dto.JoinusDto;
import com.btea.result.R;
import com.btea.service.JoinusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 19:23
 * @Description: “加入我们” 控制层
 */
@CrossOrigin
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

        // 如果年级长度不等于 4
        if (joinusDto.getGrade().length() != 4) {
            List<Map<String, Object>> data = Collections.singletonList(
                    Collections.singletonMap("result", "你这年级确定填对了?")
            );
            return R.unprocessableEntity(data);
            // 判断手机号格式
        } else if (!joinusDto.getPhone().matches("^1[3|4|5|7|8][0-9]{9}$")) {
            List<Map<String, Object>> data = Collections.singletonList(
                    Collections.singletonMap("result", "你这手机号不对吧...")
            );
            return R.unprocessableEntity(data);
            // 判断邮箱格式
        } else if (!joinusDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$")) {
            List<Map<String, Object>> data = Collections.singletonList(
                    Collections.singletonMap("result", "你这邮箱不对吧...")
            );
            return R.unprocessableEntity(data);
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
    public R roster(HttpSession session) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.notLoggedIn();
        }
        List<Map<String, Object>> data = joinusService.selectAllMember();

        return R.data(data);
    }
}
