package com.trainingsystem.dddexample.domain.model.entity;

import com.trainingsystem.dddexample.domain.model.valobj.MvpTime;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;

import java.util.Objects;

public class PlayerEntity {
    /**
     * 数据库自增主键
     */
    private Long id;

    /**
     * 玩家ID
     */
    private PlayerId playerId;

    /**
     * 首次获得MVP时间，默认是9999-12-31 23:59:59
     */
    private MvpTime firstMvpTime;

    /**
     * 累计跟几个妹子组过CP
     */
    private Integer cpCount;

    /**
     * 上一个CP的玩家ID，相同的话不累加
     */
    private PlayerId lastCpPlayerId;


    public void addCpPlayer(PlayerId cpPlayerId){
        if (cpPlayerId.equals(lastCpPlayerId)) {
            return;
        }
        this.lastCpPlayerId = cpPlayerId;
        this.cpCount++;
    }


    public void firstMvp(MvpTime mvpTime){
        //判断时间是否在默认时间之前
        if (Objects.isNull(firstMvpTime) || mvpTime.getMvpTime().before(firstMvpTime.getMvpTime())) {
            this.firstMvpTime = mvpTime;
        }
    }
}
