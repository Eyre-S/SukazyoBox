package cc.sukazyo.sukbox.util;

import java.util.Calendar;

public class Logout {
	
	public static void info (String log) {
		System.out.println("[" + Calendar.getInstance().getTime() + "][" + Thread.currentThread() + "][INFO]" + log);
	}
	
}
