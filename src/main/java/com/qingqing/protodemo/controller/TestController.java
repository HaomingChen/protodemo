package com.qingqing.protodemo.controller;

import com.qingqing.protodemo.protoresources.protobuf.MessageUserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author Haoming Chen
 * @date 2020/5/21 13:33
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", produces = "application/x-protobuf")
    @ResponseBody
    public MessageUserLogin.MessageUserLoginResponse getPersonProto(@RequestBody MessageUserLogin.MessageUserLoginRequest request) {

        MessageUserLogin.MessageUserLoginResponse.Builder builder = MessageUserLogin.MessageUserLoginResponse.newBuilder();
        builder.setAccessToken(UUID.randomUUID().toString());
        builder.setUsername(request.getUsername());
        return builder.build();

    }

}
