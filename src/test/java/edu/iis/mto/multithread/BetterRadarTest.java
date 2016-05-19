/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;

import edu.iis.mto.multithread.repeat.Repeat;
import edu.iis.mto.multithread.repeat.RepeatRule;
import java.util.concurrent.Executor;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author student
 */

public class BetterRadarTest {
    
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat( times = 10 )
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new Executor() {
		@Override
		public void execute(Runnable command) {
			command.run();
		}
        };
        BetterRadar radar = new BetterRadar(batteryMock, executor);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}
