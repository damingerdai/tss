package org.aming.tss.base.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author daming
 * @version 2018/3/1.
 */
public class DateUtils {

	public static String getFullDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHDDssSSS");
		return dateFormat.format(new Date());
	}

	public static void main(String[] args) {
		System.out.println(getFullDateTime());
		System.out.println(Instant.now().toString());
	}
}
