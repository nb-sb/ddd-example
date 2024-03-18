package com.trainingsystem.tradition.listener;


import com.trainingsystem.tradition.dto.CpMessage;
import com.trainingsystem.tradition.service.PlayerOpeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * CP消息监听器
 */
@Component
public class CpListener {

    @Resource
    private PlayerOpeService playerOpeService;


    public void messageHandler(String message) {
//        CpMessage cpMessage = JSON.parseObject(message, CpMessage.class);
//        playerOpeService.handleCpCount(cpMessage);
    }

}
