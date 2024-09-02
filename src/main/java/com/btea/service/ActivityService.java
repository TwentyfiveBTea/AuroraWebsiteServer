package com.btea.service;

import com.btea.dto.ActivityDto;

import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/21 20:15
 * @Description: “团建” 接口
 */
public interface ActivityService {
    /**
     * 上传团建信息
     *
     * @param activityDto
     * @return 插入数据的条数
     */
    int insertNewActivity(ActivityDto activityDto);

    /**
     * 查询所有团建信息
     *
     * @return 团建信息
     */
    List<Map<String, Object>> selectAllActivity();
}
