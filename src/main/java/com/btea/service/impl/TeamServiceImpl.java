package com.btea.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btea.dto.TeamDto;
import com.btea.mapper.TeamMapper;
import com.btea.pojo.Team;
import com.btea.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 15:20
 * @Description: “团队照片” 接口实现类
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public int insertNewPhoto(TeamDto teamDto) {
        Team team = new Team();
        team.setGrade(teamDto.getGrade());
        team.setOrientation(teamDto.getOrientation());
        team.setName(teamDto.getName());
        team.setPositionOne(teamDto.getPositionOne());
        team.setWord(teamDto.getWord());
        team.setPicture(teamDto.getPicture());

        return teamMapper.insert(team);
    }

    @Override
    public List<Map<String, Object>> selectPhotoByGradeAndOrientation(String grade, String orientation) {
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("grade", "orientation", "name", "position_one", "position_two", "word", "picture")
                .eq("grade", grade)
                .eq("orientation", orientation);


        return teamMapper.selectMaps(queryWrapper);
    }
}
