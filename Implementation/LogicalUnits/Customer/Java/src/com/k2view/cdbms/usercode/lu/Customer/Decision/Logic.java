/////////////////////////////////////////////////////////////////////////
// LU Functions
/////////////////////////////////////////////////////////////////////////

package com.k2view.cdbms.usercode.lu.Customer.Decision;

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


	@type(DecisionFunction)
	@out(name = "decision", type = Boolean.class, desc = "")
	public static Boolean RUN_POPULATION() throws Exception {
			// this function will decide to synchronize an LUI if the number of cases is higher than an arbitrary hardcoded threshold
		
			//int CRMCases_threshold = 25000; //latest kwnown number of cases in CRM_DB.CASES.
			Boolean syncInd = false;
			String count = db("CRM_DB").fetch("SELECT count(*) FROM CASES").firstValue().toString();
			
			//puts the number of rows in the CASES into a variable count.
			
			reportUserMessage(count);
			//log.info(count);
			
			int cnt = Integer.parseInt(count);
			
			if (cnt > Integer.parseInt(RUN_POP)){
			
			reportUserMessage("new case in !!");
				//log.info("new case in !!");
				
			syncInd = true;
			}
			return syncInd;
	}

	
	
	
	
}
