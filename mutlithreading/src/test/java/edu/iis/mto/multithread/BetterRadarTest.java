
package edu.iis.mto.multithread;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.Executor;



@ExtendWith(MockitoExtension.class)
class BetterRadarTest {

    @Mock
    private PatriotBattery batteryMock;


    @RepeatedTest(100)
    void when_TenRocketsInRadar_Expect_CallLaunchPatriotTenTimes() {
        Executor executor = Runnable::run;
        int rocketCount = 10;

        BetterRadar radar = new BetterRadar(rocketCount, batteryMock, executor);

        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);

        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(100)
    void when_LessThanOneRocketInRadar_Expect_CallLaunchPatriotOnes() {
        Executor executor = Runnable::run;
        final int rocketCount = 0;

        BetterRadar radar = new BetterRadar(rocketCount, batteryMock, executor);

        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);

        verify(batteryMock, atLeastOnce()).launchPatriot(enemyMissile);
    }

}
