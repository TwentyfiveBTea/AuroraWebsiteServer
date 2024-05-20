package com.btea.service;

import com.btea.dto.JoinDto;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 17:31
 * @Description: “加入我们” 接口
 */
public interface JoinService {

    /**
     * 新成员报名
     * @param joinDto
     */
    int insertMember(JoinDto joinDto);

    /**
     * 查询所有已经报名的成员
     */
    String selectAllMember();

}
