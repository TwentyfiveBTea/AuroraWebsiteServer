package com.btea.service;

import com.btea.dto.JoinusDto;

import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 17:31
 * @Description: “加入我们” 接口
 */
public interface JoinusService {

    /**
     * 新成员报名
     *
     * @param joinusDto
     * @return 插入数据的条数
     */
    int insertMember(JoinusDto joinusDto);

    /**
     * 查询所有已经报名的成员
     *
     * @return 所有报名人的信息
     */
    List<Map<String, Object>> selectAllMember();
}
