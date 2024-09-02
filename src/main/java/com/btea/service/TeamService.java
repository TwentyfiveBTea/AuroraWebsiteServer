package com.btea.service;

import com.btea.dto.TeamDto;

import java.util.List;
import java.util.Map;

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
    List<Map<String, Object>> selectPhotoByGradeAndOrientation(String grade, String orientation);
}
