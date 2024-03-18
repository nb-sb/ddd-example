package com.trainingsystem.dddexample.domain.model.valobj;

import lombok.Data;
import org.springframework.util.StringUtils;
@Data
public class PlayerId {
    private String playerId;

    public PlayerId(String playerId){
        if (StringUtils.isEmpty(playerId)) {
            throw new IllegalArgumentException();
        }
        this.playerId = playerId;
    }
}
