package cc.sukazyo.sukbox.util;

import java.util.Calendar;

public class Logout {
	
	public static void info (String log) {
		System.out.println(prefix() + log);
	}
	
	public static void error (String log, Exception e) {
		System.err.println(prefix() + log);
		e.printStackTrace();
	}
	
	private static String prefix () {
		return "[" + Calendar.getInstance().getTime() + "][" + Thread.currentThread() + "][INFO]";
	}
	
}
