package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private final int rocketCount;
    private PatriotBattery battery;
    private Executor executor;

    public BetterRadar(int rocket_count, PatriotBattery battery, Executor executor) {
        if(rocket_count<1)
            rocket_count = 1;
        this.rocketCount = rocket_count;
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rocketCount);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        executor.execute(new LaunchPatriotTask(enemyMissle, rocketCount, battery));
    }
}