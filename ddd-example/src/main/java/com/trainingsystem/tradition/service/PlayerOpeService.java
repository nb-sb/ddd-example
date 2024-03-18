package com.trainingsystem.tradition.service;


import com.trainingsystem.tradition.dao.PlayOpeMapper;
import com.trainingsystem.tradition.dto.MvpMessage;
import com.trainingsystem.tradition.entity.PlayerOpe;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

import com.trainingsystem.tradition.dto.CpMessage;
@Service
public class PlayerOpeService {

    @Resource
    PlayOpeMapper playOpeMapper;

    public void handleCpCount(CpMessage cpMessage) {

        String playerId = cpMessage.getPlayerId();
        if (StringUtils.isEmpty(playerId)) {
            throw new IllegalArgumentException();
        }
        String cpPlayerId = cpMessage.getCpPlayerId();
        if (StringUtils.isEmpty(cpPlayerId)) {
            throw new IllegalArgumentException();
        }
        PlayerOpe playerOpe = playOpeMapper.getByPlayId(playerId);
        //没有就创建并插入
        if (playerOpe == null) {
            playerOpe = new PlayerOpe();
            playerOpe.setPlayerId(playerId);
            playerOpe.setCpCount(1);
            playerOpe.setLastCpPlayerId(cpPlayerId);
            playOpeMapper.insert(playerOpe);
        } else {
            Integer cpCount = playerOpe.getCpCount();
            //没组过CP，要初始化
            if (cpCount == null || cpCount == 0) {
                playerOpe.setCpCount(1);
                playerOpe.setLastCpPlayerId(cpPlayerId);
            } else {
                //组过CP的话，需要这次新CP的玩家ID跟上次的不一样才会统计
                //小两口闹矛盾又复合的就别记录进去了
                if (!cpPlayerId.equals(playerOpe.getLastCpPlayerId())) {
                    playerOpe.setCpCount(playerOpe.getCpCount() + 1);
                    playerOpe.setLastCpPlayerId(cpPlayerId);
                }
            }
            playOpeMapper.updateCpIdAndCount(playerOpe);
        }
    }

    public void handleMvp(MvpMessage mvpMessage) {
        String playerId = mvpMessage.getPlayerId();
        if (StringUtils.isEmpty(playerId)) {
            throw new IllegalArgumentException();
        }
        Date mvpTime = mvpMessage.getMvpTime();
        if (Objects.isNull(mvpTime)) {
            throw new IllegalArgumentException();
        }
        PlayerOpe playerOpe = playOpeMapper.getByPlayId(playerId);
        //没有就创建并插入
        if (playerOpe == null) {
            playerOpe = new PlayerOpe();
            playerOpe.setPlayerId(playerId);
            playerOpe.setFirstMvpTime(mvpTime);
            playOpeMapper.insert(playerOpe);
        } else {
            Date firstMvpTime = playerOpe.getFirstMvpTime();
            //判断时间是否在默认时间之前
            if (mvpTime.before(firstMvpTime)) {
                playerOpe.setFirstMvpTime(mvpTime);
            }
            playOpeMapper.updateFirstMvpTime(playerOpe);
        }
    }
}
