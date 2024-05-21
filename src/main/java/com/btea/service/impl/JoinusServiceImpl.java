package com.btea.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.btea.dto.JoinusDto;
import com.btea.mapper.JoinusMapper;
import com.btea.pojo.Joinus;
import com.btea.service.JoinusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/20 19:11
 * @Description: “加入我们” 接口实现类
 */
@Service
public class JoinusServiceImpl implements JoinusService {
    @Autowired
    private JoinusMapper joinusMapper;

    @Override
    public int insertMember(JoinusDto joinusDto) {
        Joinus joinus = new Joinus();
        joinus.setName(joinusDto.getName());
        joinus.setGender(joinusDto.getGender());
        joinus.setGrade(joinusDto.getGrade());
        joinus.setPhone(joinusDto.getPhone());
        joinus.setEmail(joinusDto.getEmail());
        joinus.setMajors(joinusDto.getMajors());
        joinus.setOrientation(joinusDto.getOrientation());
        joinus.setIntroduce(joinusDto.getIntroduce());

        return joinusMapper.insert(joinus);
    }

    @Override
    public String selectAllMember(int page) {
        Page<Joinus> joinusPage = new Page<>(page,10);
        QueryWrapper<Joinus> queryWrapper  = new QueryWrapper<>();
        queryWrapper.select("name","gender","grade","phone","email","majors","orientation","introduce");
        Page<Joinus> info = joinusMapper.selectPage(joinusPage, queryWrapper);
        List<Joinus> member = info.getRecords();

        return JSON.toJSONString(member);
    }
}
