package com.cybage.exception;

import java.sql.SQLException;

public class AdminError extends SQLException{
	
	AdminError(String msg){
		super(msg);
	}

}
