package com.trainingsystem.dddexample.domain.repository;

import com.trainingsystem.dddexample.domain.model.entity.PlayerEntity;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;

public interface PlayerEntityRepository {
    PlayerEntity load(PlayerId playerId);

    void save(PlayerEntity playerEntity);
}
