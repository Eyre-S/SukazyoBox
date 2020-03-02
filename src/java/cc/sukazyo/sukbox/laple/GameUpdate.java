package cc.sukazyo.sukbox.laple;


import cc.sukazyo.sukbox.util.Logout;

import java.util.Date;

public class GameUpdate extends Thread {
	
	@Override
	public void run () {
		
		long last = new Date().getTime();
		long now;
		double speed = 0;
		
		while (true) {
			now = new Date().getTime();
			speed = (now - last) / 1000.0;
			last = new Date().getTime();
//			Logout.info("当前时间戳" + String.valueOf(now));
			GameInfo.laple.health.set(GameInfo.laple.health.get() - (0.1 * speed));
		}
		
	}
}