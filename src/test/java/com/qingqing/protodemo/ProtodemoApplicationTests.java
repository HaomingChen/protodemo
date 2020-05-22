package com.qingqing.protodemo;

import com.qingqing.protodemo.entities.AgentAccountPermission;
import com.qingqing.protodemo.mapper.AgentAccountPermissionMapper;
import com.qingqing.protodemo.protoresources.protobuf.AgentAccountPermissionProto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@SpringBootTest
class ProtodemoApplicationTests {


    @Autowired
    private AgentAccountPermissionMapper agentAccountPermissionMapper;


    @Test
    void contextLoads() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            URI uri = new URI("http", null, "127.0.0.1", 8027, "/agent-account-permission", "", null);
            HttpPost post = new HttpPost(uri);
            AgentAccountPermissionProto.ListAgentAccountPermissionRequest.Builder builder = AgentAccountPermissionProto
                    .ListAgentAccountPermissionRequest.newBuilder();
            builder.setId("1234");
            post.setEntity(new ByteArrayEntity(builder.build().toByteArray()));
            post.setHeader("Content-Type", "application/x-protobuf");

            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                AgentAccountPermissionProto.ListAgentAccountPermissionResponse resp =
                        AgentAccountPermissionProto.ListAgentAccountPermissionResponse.parseFrom(response.getEntity().getContent());
                System.out.println("result:");
                resp.getPermissionInfoList().forEach(agentPermissionInfo -> {
                    System.out.println(agentPermissionInfo.getAgentAccountId());
                    System.out.println(agentPermissionInfo.getId());
                });
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            httpClient.close();
        }
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<AgentAccountPermission> userList;
        userList = agentAccountPermissionMapper.selectList(null);
        Assert.assertEquals(36, userList.size());
        userList.forEach(System.out::println);
    }

}
