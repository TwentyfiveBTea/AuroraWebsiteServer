package com.btea.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btea.dto.JoinDto;
import com.btea.mapper.JoinMapper;
import com.btea.pojo.Join;
import com.btea.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 19:11
 * @Description: “加入我们” 接口实现类
 */
@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinMapper joinMapper;

    @Override
    public int insertMember(JoinDto joinDto) {
        Join join = new Join();
        join.setName(joinDto.getName());
        join.setGender(joinDto.getGender());
        join.setGrade(joinDto.getGrade());
        join.setPhone(join.getPhone());
        join.setEmail(joinDto.getEmail());
        join.setMajors(joinDto.getMajors());
        join.setOrientation(joinDto.getOrientation());
        join.setIntroduce(joinDto.getIntroduce());

        return joinMapper.insert(join);
    }

    @Override
    public String selectAllMember() {
        QueryWrapper<Join> queryWrapper  = new QueryWrapper<>();
        queryWrapper.select("name","gender","grade","phone","email","majors","orientation","introduce");
        List<Join> member = joinMapper.selectList(queryWrapper);
        return JSON.toJSONString(member);
    }
}
