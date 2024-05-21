package com.btea.service;

import com.btea.dto.ActivityDto;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/21 20:15
 * @Description: “展现团建风采” 接口
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
     * 分页查询所有团建信息
     *
     * @param page
     * @return 团建信息
     */
    String selectAllActivity(int page);
}
