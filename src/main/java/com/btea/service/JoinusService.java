package com.btea.service;

import com.btea.dto.JoinusDto;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 17:31
 * @Description: “加入我们” 接口
 */
public interface JoinusService {

    /**
     * 新成员报名
     * @param joinusDto
     * @return 插入数据的条数
     */
    int insertMember(JoinusDto joinusDto);

    /**
     * 分页查询所有已经报名的成员
     */
    String selectAllMember(int page);
}
