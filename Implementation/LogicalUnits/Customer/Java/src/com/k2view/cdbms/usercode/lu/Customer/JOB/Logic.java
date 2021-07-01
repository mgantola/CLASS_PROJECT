/////////////////////////////////////////////////////////////////////////
// LU Functions
/////////////////////////////////////////////////////////////////////////

package com.k2view.cdbms.usercode.lu.Customer.JOB;

import java.util.*;
import java.sql.*;
import java.math.*;
import java.io.*;

import com.k2view.cdbms.shared.*;
import com.k2view.cdbms.shared.Globals;
import com.k2view.cdbms.shared.user.UserCode;
import com.k2view.cdbms.sync.*;
import com.k2view.cdbms.lut.*;
import com.k2view.cdbms.shared.utils.UserCodeDescribe.*;
import com.k2view.cdbms.shared.logging.LogEntry.*;
import com.k2view.cdbms.func.oracle.OracleToDate;
import com.k2view.cdbms.func.oracle.OracleRownum;
import com.k2view.cdbms.usercode.lu.Customer.*;
import com.k2view.fabric.events.*;
import com.k2view.fabric.fabricdb.datachange.TableDataChange;

import static com.k2view.cdbms.shared.utils.UserCodeDescribe.FunctionType.*;
import static com.k2view.cdbms.shared.user.ProductFunctions.*;
import static com.k2view.cdbms.usercode.common.SharedLogic.*;
import static com.k2view.cdbms.usercode.lu.Customer.Globals.*;

@SuppressWarnings({"unused", "DefaultAnnotationParam"})
public class Logic extends UserCode {


	@type(UserJob)
	public static void TS_JOB_FILE_CREATION() throws Exception {
		String TS_job = k2_currentDateTime();
		String number_of_iDs = db("CRM_DB").fetch("SELECT count(*) FROM CUSTOMER").firstValue().toString();
		
		FileWriter myWriter = new FileWriter("list_entities.txt",true); //set to true to enable append mode
		
		myWriter.write("At this Date & Time :: "+TS_job+", there are: "+number_of_iDs+" entities in CRM_DB.");myWriter.close();
	}

	
	
	
	
}
