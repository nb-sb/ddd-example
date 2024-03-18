package com.trainingsystem.dddexample.domain.factory;

import com.trainingsystem.dddexample.domain.model.entity.PlayerEntity;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;

public interface PlayerEntityFactory {
    PlayerEntity newInstance(PlayerId playerId);
}
