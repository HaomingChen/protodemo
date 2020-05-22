package com.qingqing.protodemo.service.impl;

import com.qingqing.protodemo.entities.AgentAccountPermission;
import com.qingqing.protodemo.mapper.AgentAccountPermissionMapper;
import com.qingqing.protodemo.service.AgentPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haoming Chen
 * @date 2020/5/22 15:32
 */
@Service
public class AgentPermissionServiceImpl implements AgentPermissionService {

    @Autowired
    AgentAccountPermissionMapper agentAccountPermissionMapper;

    @Override
    public List<AgentAccountPermission> agentAccountPermissionList() {
        return agentAccountPermissionMapper.selectList(null);
    }

}
