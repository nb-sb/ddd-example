package com.trainingsystem.dddexample.application.mvp;

import lombok.Data;

import java.util.Date;


@Data
public class MvpCommand {

    private String playerId;

    private Date mvpTime;
}
