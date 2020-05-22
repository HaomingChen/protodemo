package com.qingqing.protodemo.converter;

import com.qingqing.protodemo.entities.AgentAccountPermission;
import com.qingqing.protodemo.protoresources.protobuf.AgentAccountPermissionProto;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author Haoming Chen
 * @date 2020/5/22 16:06
 */
public class AgentAccountPermissionConverter {

    public static void convertAgentAccountPermission(List<AgentAccountPermission> source,
                                                     AgentAccountPermissionProto.ListAgentAccountPermissionResponse.Builder target) {
        if (CollectionUtils.isEmpty(source)) {
            throw new IllegalArgumentException("列表不存在");
        }
        for (int i = 0; i < source.size(); i++) {
            AgentAccountPermissionProto.AgentPermissionInfo.Builder builder = AgentAccountPermissionProto.AgentPermissionInfo.newBuilder();
            builder.setAgentAccountId(String.valueOf(source.get(i).getAgentAccountId()))
                    .setId(String.valueOf(source.get(i).getId()));
            target.addPermissionInfo(builder.build());
        }

    }
}
