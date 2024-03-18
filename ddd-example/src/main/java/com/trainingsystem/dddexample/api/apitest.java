package com.trainingsystem.dddexample.api;

import com.trainingsystem.dddexample.application.cp.CpCommand;
import com.trainingsystem.dddexample.application.mvp.MvpCommand;

public interface apitest {
    public void handleCpCount(CpCommand cpCommand);

    public void handleMvp(MvpCommand mvpCommand);
}
