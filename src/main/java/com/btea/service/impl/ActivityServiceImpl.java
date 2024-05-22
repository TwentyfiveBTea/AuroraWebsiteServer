package com.btea.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.btea.dto.ActivityDto;
import com.btea.mapper.ActivityMapper;
import com.btea.pojo.Activity;
import com.btea.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/21 20:15
 * @Description: “团建” 接口实现类
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insertNewActivity(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setTheme(activityDto.getTheme());
        activity.setDescribes(activityDto.getDescribes());
        activity.setTime(activityDto.getTime());
        activity.setPictureOne(activityDto.getPictureOne());
        activity.setPictureTwo(activityDto.getPictureTwo());
        activity.setPictureThree(activityDto.getPictureThree());

        return activityMapper.insert(activity);
    }

    @Override
    public String selectPageAllActivity(int page) {
        Page<Activity> activityPage = new Page<>(page, 4);
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("theme", "time", "describes", "picture_one", "picture_two", "picture_three");
        Page<Activity> act = activityMapper.selectPage(activityPage, queryWrapper);
        List<Activity> activity = act.getRecords();

        return JSON.toJSONString(activity);
    }
}
