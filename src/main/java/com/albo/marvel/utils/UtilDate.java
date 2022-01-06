package com.albo.marvel.utils;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UtilDate {

	public static String getFormatDate(Date date,String format) {
		String result = null;
		if (date != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			result = dateFormat.format(date);
		}
		return result;
	}
}
