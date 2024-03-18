package com.trainingsystem.dddexample.application;

import com.trainingsystem.dddexample.application.cp.CpCommand;
import com.trainingsystem.dddexample.application.mvp.MvpCommand;
import com.trainingsystem.dddexample.domain.factory.PlayerEntityFactory;
import com.trainingsystem.dddexample.domain.model.entity.PlayerEntity;
import com.trainingsystem.dddexample.domain.model.valobj.MvpTime;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;
import com.trainingsystem.dddexample.domain.repository.PlayerEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@AllArgsConstructor
public class PlayerOpeService {

    final private PlayerEntityFactory playerEntityFactory;
    final private PlayerEntityRepository playerEntityRepository;

    public void handleCpCount(CpCommand cpCommand){
        PlayerId playerId = new PlayerId(cpCommand.getPlayerId());
        PlayerId cpPlayerId = new PlayerId(cpCommand.getPlayerId());

        PlayerEntity playerEntity = playerEntityRepository.load(playerId);
        if (playerEntity == null) {
            playerEntity = playerEntityFactory.newInstance(playerId);
        }
        playerEntity.addCpPlayer(cpPlayerId);
        playerEntityRepository.save(playerEntity);
    }

    public void handleMvp(MvpCommand mvpCommand){
        PlayerId playerId = new PlayerId(mvpCommand.getPlayerId());
        MvpTime mvpTime = new MvpTime(mvpCommand.getMvpTime());

        PlayerEntity playerEntity = playerEntityRepository.load(playerId);
        if (playerEntity == null) {
            playerEntity = playerEntityFactory.newInstance(playerId);
        }
        playerEntity.firstMvp(mvpTime);
        playerEntityRepository.save(playerEntity);
    }
}
