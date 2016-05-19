/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

/**
 *
 * @author student
 */
public class BetterRadar{
    	private PatriotBattery battery;
        private final Executor executor;
	public BetterRadar(PatriotBattery missle, Executor executor) {
            this.battery = missle;
            this.executor = executor;
	}

	public void notice(Scud enemyMissle) {
            launchPatriot();
	}
        

	private final Runnable launchPatriotTask = new Runnable() {

                @Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				battery.launchPatriot();
			}
		}
	};
	
	private void launchPatriot() {
		executor.execute(launchPatriotTask);
	}

}
