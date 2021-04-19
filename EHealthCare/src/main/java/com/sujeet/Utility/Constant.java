package com.sujeet.Utility;

import java.sql.SQLIntegrityConstraintViolationException;

public class Constant {

	public static String getMessage(Exception exception) {
		if(exception instanceof SQLIntegrityConstraintViolationException) {
			return "This data is already present";
		}
		else if (exception instanceof Exception) {
			return "try after some time";
		}
		else {
		return "Nothing";
		}
	}

}
