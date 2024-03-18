package com.trainingsystem.dddexample.domain.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MvpTime {
    private Date mvpTime;


}
