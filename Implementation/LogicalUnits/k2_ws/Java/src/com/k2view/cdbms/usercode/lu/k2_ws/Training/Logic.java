/////////////////////////////////////////////////////////////////////////
// Project Web Services
/////////////////////////////////////////////////////////////////////////

package com.k2view.cdbms.usercode.lu.k2_ws.Training;

import java.util.*;
import java.sql.*;
import java.math.*;
import java.io.*;

import com.k2view.cdbms.shared.*;
import com.k2view.cdbms.shared.user.WebServiceUserCode;
import com.k2view.cdbms.sync.*;
import com.k2view.cdbms.lut.*;
import com.k2view.cdbms.shared.utils.UserCodeDescribe.*;
import com.k2view.cdbms.shared.logging.LogEntry.*;
import com.k2view.cdbms.func.oracle.OracleToDate;
import com.k2view.cdbms.func.oracle.OracleRownum;
import com.k2view.cdbms.usercode.lu.k2_ws.*;
import com.k2view.fabric.api.endpoint.Endpoint.*;

import static com.k2view.cdbms.shared.utils.UserCodeDescribe.FunctionType.*;
import static com.k2view.cdbms.shared.user.ProductFunctions.*;
import static com.k2view.cdbms.usercode.common.SharedLogic.*;
import static com.k2view.cdbms.usercode.common.SharedGlobals.*;

@SuppressWarnings({"unused", "DefaultAnnotationParam"})
public class Logic extends WebServiceUserCode {


	@desc("Simple web services for Customer information.")
	@webService(path = "traing/GetCustomer", verb = {MethodType.GET, MethodType.POST, MethodType.PUT, MethodType.DELETE}, version = "1", isRaw = false, isCustomPayload = false, produce = {Produce.XML, Produce.JSON})
	public static Object wsGetCustomer(String i_id) throws Exception {
		String sql = "SELECT CUSTOMER_ID, SSN, FIRST_NAME, LAST_NAME FROM Customer.CUSTOMER";
		Db.Rows rows = ludb("Customer", i_id).fetch(sql);
		reportUserMessage("My This Web Services is Running");
		//log.info();
		return rows;
	}


	@webService(path = "train/GetCustomer2", verb = {MethodType.GET, MethodType.POST, MethodType.PUT, MethodType.DELETE}, version = "1", isRaw = false, isCustomPayload = false, produce = {Produce.XML, Produce.JSON})
	public static Object wsGetCustomer2(String i_id, String i_vipStatus) throws Exception {
		String sql = "SELECT cust.FIRST_NAME, cust.LAST_NAME, cont.CONTRACT_ID, cont.CONTRACT_DESCRIPTION," +
		"sub.SUBSCRIBER_ID, sub.MSISDN, sub.IMSI, sub.SIM, sub.SUBSCRIBER_TYPE, sub.VIP_STATUS " +
		"FROM CUSTOMER cust, CONTRACT cont, SUBSCRIBER sub where cont.ASSOCIATED_LINE_FMT = sub.MSISDN and sub.VIP_STATUS = ?";
		Db.Rows rows = ludb("Customer",i_id).fetch(sql,i_vipStatus);
		log.info("WS executed Successfully for Customer ID:" + i_id);
		return rows;
	}

	
	

	
}
