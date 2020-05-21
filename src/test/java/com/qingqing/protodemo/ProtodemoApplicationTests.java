package com.qingqing.protodemo;

import com.qingqing.protodemo.dao.entity.User;
import com.qingqing.protodemo.dao.mapper.UserMapper;
import com.qingqing.protodemo.protoresources.protobuf.MessageUserLogin;
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
    private UserMapper userMapper;


    @Test
    void contextLoads() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            URI uri = new URI("http", null, "127.0.0.1", 8027, "/test", "", null);
            HttpPost post = new HttpPost(uri);
            MessageUserLogin.MessageUserLoginRequest.Builder builder = MessageUserLogin.MessageUserLoginRequest.newBuilder();
            builder.setUsername("mike").setPassword("123456");
            post.setEntity(new ByteArrayEntity(builder.build().toByteArray()));
            post.setHeader("Content-Type", "application/x-protobuf");

            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                MessageUserLogin.MessageUserLoginResponse resp = MessageUserLogin.MessageUserLoginResponse.parseFrom(response.getEntity().getContent());
                System.out.println("result:" + resp.getAccessToken());
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
        List<User> userList;
        userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
