package com.btea.controller;

import com.btea.dto.ActivityDto;
import com.btea.result.R;
import com.btea.service.ActivityService;
import com.btea.utils.fileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/21 20:28
 * @Description: “团建活动” 控制层
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation("展现团队风采接口")
    @PostMapping("/settings/show")
    public R show(@RequestParam("theme") String theme, @RequestParam("time") String time,
                  @RequestParam("describes") String describes,
                  @RequestParam("file1") MultipartFile file1,
                  @RequestParam("file2") MultipartFile file2,
                  @RequestParam("file3") MultipartFile file3, HttpServletRequest request) {

        fileUtil fileUtil = new fileUtil();
        String fileName1 = fileUtil.upload(file1, request);
        String fileName2 = fileUtil.upload(file2, request);
        String fileName3 = fileUtil.upload(file3, request);

        ActivityDto activityDto = new ActivityDto();
        activityDto.setTheme(theme);
        activityDto.setTime(time);
        activityDto.setDescribes(describes);
        activityDto.setPictureOne(fileName1);
        activityDto.setPictureTwo(fileName2);
        activityDto.setPictureThree(fileName3);

        int i = activityService.insertNewActivity(activityDto);
        if (i == 1) {
            return R.ok();
        } else {
            return R.serverError();
        }
    }

    @ApiOperation("团建活动展示接口")
    @GetMapping("/about/activity")
    public R activity(int page) {
        String activity = activityService.selectAllActivity(page);
        return R.ok(activity);
    }

}
