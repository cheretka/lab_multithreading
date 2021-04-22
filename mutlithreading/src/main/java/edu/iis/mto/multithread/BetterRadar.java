package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private final int rocketCount;
    private PatriotBattery battery;
    private Executor executor;

    public BetterRadar(int rocket_count, PatriotBattery battery, Executor executor) {
        this.rocketCount = rocket_count;
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        executor.execute(new LaunchPatriotTask(enemyMissle, rocketCount, battery));
    }
}
