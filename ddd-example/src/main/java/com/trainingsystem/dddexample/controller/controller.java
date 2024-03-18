package com.trainingsystem.dddexample.controller;

import com.trainingsystem.dddexample.api.apitest;
import com.trainingsystem.dddexample.application.cp.CpCommand;
import com.trainingsystem.dddexample.application.mvp.MvpCommand;
import org.springframework.web.bind.annotation.RestController;

/**
* @author: Wanghaonan @戏人看戏
* @description: 实现api层的接口，并使用app层中的方法
* @create: 2024/3/18 19:42
*/
@RestController
public class controller implements apitest {
    @Override
    public void handleCpCount(CpCommand cpCommand) {

    }

    @Override
    public void handleMvp(MvpCommand mvpCommand) {

    }
}
