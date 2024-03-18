package com.trainingsystem.tradition.listener;


import com.trainingsystem.tradition.dto.MvpMessage;
import com.trainingsystem.tradition.service.PlayerOpeService;

import javax.annotation.Resource;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

public class MvpListener {

    @Resource
    private PlayerOpeService playerOpeService;


    public void messageHandler(String message) {
//        MvpMessage mvpMessage = JSON.parseObject(message, MvpMessage.class);
//        playerOpeService.handleMvp(mvpMessage);
    }
}
