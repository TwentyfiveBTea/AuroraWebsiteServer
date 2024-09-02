package com.btea.service;

import com.btea.dto.AchievementDto;

import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 13:36
 * @Description: “成就” 接口
 */
public interface AchievementService {
    /**
     * 上传成就
     *
     * @param achievementDto
     * @return 插入数据的条数
     */
    int insertNewAchievement(AchievementDto achievementDto);

    /**
     * 根据组别查询对应成就
     *
     * @param team
     * @return 该组成就
     */
    List<Map<String, Object>> selectAchievementByGroup(String team);

}
