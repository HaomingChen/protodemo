package com.qingqing.protodemo.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author chenhaoming
 */
@Data
@TableName("t_agent_account_permission")
public class AgentAccountPermission {

    private Long id;

    private Long agentAccountId;

    private Integer permission;

    private Boolean isDeleted;

    private Date createTime;

    private Long createUserId;

    private Date lastUpdateTime;

    private Long lastUpdateUserId;

}