package edu.iis.mto.multithread;


class LaunchPatriotTask implements Runnable {

    private Scud enemyMissle;
    private final int rocketCount;
    private PatriotBattery battery;

    public LaunchPatriotTask(Scud enemyMissle, int rocketCount, PatriotBattery battery) {
        this.enemyMissle = enemyMissle;
        this.rocketCount = rocketCount;
        this.battery = battery;
    }

    @Override
    public void run() {
        for (int i = 0; i < rocketCount; i++) {
            battery.launchPatriot(enemyMissle);
        }
    }
}

