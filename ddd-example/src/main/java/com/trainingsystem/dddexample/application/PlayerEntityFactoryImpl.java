package com.trainingsystem.dddexample.application;

import com.trainingsystem.dddexample.domain.factory.PlayerEntityFactory;
import com.trainingsystem.dddexample.domain.model.entity.PlayerEntity;
import com.trainingsystem.dddexample.domain.model.valobj.PlayerId;
import org.springframework.stereotype.Service;

/**
* @author: Wanghaonan @戏人看戏
* @description: 依赖倒置，对domain层中的工厂进行解耦
* @create: 2024/3/18 19:34
*/
@Service
public class PlayerEntityFactoryImpl implements PlayerEntityFactory {
    @Override
    public PlayerEntity newInstance(PlayerId playerId) {
        return null;
    }
}
