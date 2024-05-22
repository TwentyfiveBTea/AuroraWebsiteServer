package com.btea.controller;

import com.btea.dto.TeamDto;
import com.btea.result.R;
import com.btea.service.TeamService;
import com.btea.utils.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 15:53
 * @Description: “团队照片” 控制层
 */
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @ApiOperation("上传照片接口")
    @PostMapping("/settings/upload")
    public R upload(@RequestParam("grade") String grade, @RequestParam("orientation") String orientation,
                    @RequestParam("name") String name, @RequestParam("positionOne") String positionOne,
                    @RequestParam("positionTwo") String positionTwo, @RequestParam("word") String word,
                    MultipartFile file, HttpServletRequest request, HttpSession session) {

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.notLoggedIn();
        }

        FileUtil fileUtil = new FileUtil();
        String fileName = fileUtil.upload(file, request);

        TeamDto teamDto = new TeamDto();
        teamDto.setGrade(grade);
        teamDto.setOrientation(orientation);
        teamDto.setName(name);
        teamDto.setWord(word);
        teamDto.setPicture(fileName);

        if (positionOne.isEmpty() && positionTwo.isEmpty()) {
            teamDto.setPositionOne("普通成员");
        } else {
            teamDto.setPositionOne(positionOne);
            teamDto.setPositionTwo(positionTwo);
        }

        int i = teamService.insertNewPhoto(teamDto);
        if (i == 1) {
            return R.ok();
        } else {
            return R.serverError();
        }
    }

    @ApiOperation("团队接口")
    @GetMapping("/about/member")
    public R member(@RequestParam("grade") String grade, @RequestParam("orientation") String orientation) {
        String info = teamService.selectPhotoByGradeAndOrientation(grade, orientation);
        return R.ok(info);
    }

}
