package com.btea.service;

import com.btea.dto.TeamDto;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 15:19
 * @Description: “团队照片” 接口
 */
public interface TeamService {
    /**
     * 上传照片
     *
     * @param teamDto
     * @return 插入数据的条数
     */
    int insertNewPhoto(TeamDto teamDto);

    /**
     * 根据年级和方向查询图片
     *
     * @param grade
     * @param orientation
     * @return 返回对应的照片
     */
    String selectPhotoByGradeAndOrientation(String grade, String orientation);
}
