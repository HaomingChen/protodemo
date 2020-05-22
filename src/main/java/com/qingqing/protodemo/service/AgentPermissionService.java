package com.qingqing.protodemo.service;

import com.qingqing.protodemo.entities.AgentAccountPermission;

import java.util.List;

/**
 * @author Haoming Chen
 * @date 2020/5/22 15:32
 */
public interface AgentPermissionService {

    /**
     * 查询AgentAccountPermission
     *
     * @return 代理商账户权限列表
     */
    List<AgentAccountPermission> agentAccountPermissionList();
}
