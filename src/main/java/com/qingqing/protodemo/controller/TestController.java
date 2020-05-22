package com.qingqing.protodemo.controller;

import com.qingqing.protodemo.converter.AgentAccountPermissionConverter;
import com.qingqing.protodemo.entities.AgentAccountPermission;
import com.qingqing.protodemo.protoresources.protobuf.AgentAccountPermissionProto;
import com.qingqing.protodemo.service.AgentPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Haoming Chen
 * @date 2020/5/21 13:33
 */
@Controller
public class TestController {

    @Autowired
    AgentPermissionService agentPermissionService;

    @RequestMapping(value = "/agent-account-permission", produces = "application/x-protobuf")
    @ResponseBody
    public AgentAccountPermissionProto.ListAgentAccountPermissionResponse listAgentPermission(
            @RequestBody AgentAccountPermissionProto.ListAgentAccountPermissionRequest request) {

        AgentAccountPermissionProto.ListAgentAccountPermissionResponse.Builder builder = AgentAccountPermissionProto
                .ListAgentAccountPermissionResponse.newBuilder();
        List<AgentAccountPermission> list = agentPermissionService.agentAccountPermissionList();
        AgentAccountPermissionConverter.convertAgentAccountPermission(list, builder);
        return builder.build();

    }

}
