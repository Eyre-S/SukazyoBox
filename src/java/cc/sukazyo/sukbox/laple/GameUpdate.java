package cc.sukazyo.sukbox.laple;


import cc.sukazyo.sukbox.util.Logout;

import java.util.Date;

public class GameUpdate extends Thread {
	
	private double uhealth;
	
	@Override
	public void run() {
		
		long last = new Date().getTime();
		long now;
		double speed = 0;
		
		while (true) {
			
			// 时间戳操作
			now = new Date().getTime();
			speed = (now - last) / 60000.0;
			last = new Date().getTime();
//			Logout.info("当前时间戳" + String.valueOf(now));
			
			// 数据复制
			double health       = GameInfo.laple.health.get();
			double temperature  = GameInfo.laple.temperature.get();
			double bloody       = GameInfo.laple.bloody.get();
			double hunger       = GameInfo.laple.hunger.get();
			double water        = GameInfo.laple.water.get();
			double clean        = GameInfo.laple.clean.get();
			double power        = GameInfo.laple.power.get();
			double mood         = GameInfo.laple.mood.get();
			
			double uhealth      = 0;
			double utemperature = 0;
			double ubloody      = 0;
			double uhunger      = 0;
			double uwater       = 0;
			double uclean       = 0;
			double upower       = 0;
			double umood        = 0;
			
			// 温度偏移
			if (temperature > GameInfo.laple.temperFormat) {
				utemperature = -5;
			} else if (temperature < GameInfo.laple.temperFormat) {
				utemperature = 5;
			}
			
			// 自然血量恢复
			ubloody -= 1;
			
			// 自然饥饿
			uhunger -= 1;
			uwater -= 3;
			
			// 自然洁净降低
			uclean -= 0.5;
			
			// 自然体力恢复
			upower += 10;
			
			// 数据计算与同步
			health      += uhealth      * speed;
			temperature += utemperature * speed;
			bloody      += ubloody      * speed;
			hunger      += uhunger      * speed;
			water       += uwater       * speed;
			clean       += uclean       * speed;
			power       += upower       * speed;
			mood        += umood        * speed;
			
			health       = health      > 1 ? 1 : health      ;
			temperature  = temperature > 40 ? 40 : temperature ;
			bloody       = bloody      > 1 ? 1 : bloody      ;
			hunger       = hunger      > 1 ? 1 : hunger      ;
			water        = water       > 1 ? 1 : water       ;
			clean        = clean       > 1 ? 1 : clean       ;
			power        = power       > 1 ? 1 : power       ;
			mood         = mood        > 1 ? 1 : mood        ;
			
			health      = health      < 0 ? 0 : health      ;
			temperature = temperature < 35 ? 35 : temperature ;
			bloody      = bloody      < 0 ? 0 : bloody      ;
			hunger      = hunger      < 0 ? 0 : hunger      ;
			water       = water       < 0 ? 0 : water       ;
			clean       = clean       < 0 ? 0 : clean       ;
			power       = power       < 0 ? 0 : power       ;
			mood        = mood        < 0 ? 0 : mood        ;
			
			GameInfo.laple.health     .set(health     );
			GameInfo.laple.temperature.set(temperature);
			GameInfo.laple.bloody     .set(bloody     );
			GameInfo.laple.hunger     .set(hunger     );
			GameInfo.laple.water      .set(water      );
			GameInfo.laple.clean      .set(clean      );
			GameInfo.laple.power      .set(power      );
			GameInfo.laple.mood       .set(mood       );
			
		}
		
	}
}