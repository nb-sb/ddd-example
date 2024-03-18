package com.trainingsystem.dddexample.infrastructure.dao;

import com.trainingsystem.dddexample.domain.model.entity.PlayerEntity;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;
import com.trainingsystem.dddexample.domain.repository.PlayerEntityRepository;
import org.springframework.stereotype.Component;

/**
* @author: Wanghaonan @戏人看戏
* @description: 持久化类，将数据进行持久化
* @create: 2024/3/18 19:39
*/
@Component
public class PlayerEntityRepositoryImpl implements PlayerEntityRepository {
    @Override
    public PlayerEntity load(PlayerId playerId) {
        return null;
    }

    @Override
    public void save(PlayerEntity playerEntity) {

    }
}
