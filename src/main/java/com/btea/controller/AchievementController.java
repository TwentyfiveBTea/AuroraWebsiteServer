package com.btea.controller;

import com.btea.dto.AchievementDto;
import com.btea.result.R;
import com.btea.service.AchievementService;
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
 * @Date: 2024/05/22 14:19
 * @Description: “成就” 控制层
 */
@RestController
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @ApiOperation("发布成就接口")
    @PostMapping("/settings/announced")
    public R announced(@RequestParam("team") String team, @RequestParam("topic") String topic,
                       @RequestParam("synopsis") String synopsis,
                       @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                       HttpServletRequest request, HttpSession session) {

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.notLoggedIn();
        }

        FileUtil fileUtil = new FileUtil();
        String fileName1 = fileUtil.upload(file1, request);
        String fileName2 = fileUtil.upload(file2, request);

        AchievementDto achievementDto = new AchievementDto();
        achievementDto.setTeam(team);
        achievementDto.setTopic(topic);
        achievementDto.setSynopsis(synopsis);
        achievementDto.setPictureOne(fileName1);
        achievementDto.setPictureTwo(fileName2);

        int i = achievementService.insertNewAchievement(achievementDto);
        if (i == 1) {
            return R.ok();
        } else {
            return R.serverError();
        }
    }

    @ApiOperation("成就展示接口")
    @GetMapping("/about/project")
    public R project(String team, int page) {
        String achievements = achievementService.selectPageAchievementByGroup(team, page);
        return R.ok(achievements);

    }

}
