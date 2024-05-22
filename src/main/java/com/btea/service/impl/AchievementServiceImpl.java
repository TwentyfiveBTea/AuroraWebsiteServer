package com.btea.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.btea.dto.AchievementDto;
import com.btea.mapper.AchievementMapper;
import com.btea.pojo.Achievement;
import com.btea.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 13:36
 * @Description: “成就” 接口实现类
 */
@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public int insertNewAchievement(AchievementDto achievementDto) {
        Achievement achievement = new Achievement();
        achievement.setTeam(achievementDto.getTeam());
        achievement.setTopic(achievementDto.getTopic());
        achievement.setSynopsis(achievementDto.getSynopsis());
        achievement.setPictureOne(achievementDto.getPictureOne());
        achievement.setPictureTwo(achievementDto.getPictureTwo());

        return achievementMapper.insert(achievement);
    }

    @Override
    public String selectPageAchievementByGroup(String team, int page) {
        Page<Achievement> achievementPage = new Page<>(page, 5);
        QueryWrapper<Achievement> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("topic", "synopsis", "picture_one", "picture_two").eq("team", team);
        Page<Achievement> data = achievementMapper.selectPage(achievementPage, queryWrapper);
        List<Achievement> achievements = data.getRecords();

        return JSON.toJSONString(achievements);
    }
}
