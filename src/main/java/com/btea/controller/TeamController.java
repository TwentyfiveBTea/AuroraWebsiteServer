package com.btea.controller;

import com.btea.dto.TeamDto;
import com.btea.result.R;
import com.btea.service.TeamService;
import com.btea.utils.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 15:53
 * @Description: “团队照片” 控制层
 */
@CrossOrigin
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @ApiOperation("上传照片接口")
    @PostMapping("/imadministrator/settings/upload")
    public R upload(@RequestParam("grade") String grade, @RequestParam("orientation") String orientation,
                    @RequestParam("name") String name, @RequestParam("positionOne") String positionOne,
                    @RequestParam("positionTwo") String positionTwo, @RequestParam("word") String word,
                    MultipartFile file, HttpServletRequest request) {

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
        List<Map<String, Object>> data = teamService.selectPhotoByGradeAndOrientation(grade, orientation);

        return R.data(data);
    }
}
