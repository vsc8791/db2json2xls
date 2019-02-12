package com.darkhorse.db2json2xls.services;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.darkhorse.db2json2xls.connection.ConnectionHandler;

public class JsonServices {
//	public static List<JSONObject> getFormattedResult(ResultSet rs) {
//		List<JSONObject> resList = new ArrayList<JSONObject>();
//		try {
//			// get column names
//			ResultSetMetaData rsMeta = rs.getMetaData();
//			int columnCnt = rsMeta.getColumnCount();
//			List<String> columnNames = new ArrayList<String>();
//			// loop to get All column Names
//			for (int i = 1; i <= columnCnt; i++) {
//				// adding all retrieved column name to List Object
//				columnNames.add(rsMeta.getColumnName(i).toUpperCase());
//			}
//			while (rs.next()) {
//				// convert each object to an human readable JSON Object()
//				JSONObject obj = new JSONObject();
//				for (int i = 1; i <= columnCnt; i++) {
//					String key = columnNames.get(i - 1);
//					String value = rs.getString(i);
//					obj.put(key, value);
//				}
//				resList.add(obj);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//
//		return resList;
//	}

	
//	void jsonFileWrite(String fileName) throws JsonException {
//
//		JSONObject allEmps = new JSONObject();
//
//		JSONArray empArray = new JSONArray();
//		JSONObject empObj;
//		JSONArray phoneNumbers = null;
//		JSONObject phoneObj;
//
//		empObj = new JSONObject();
//		try {
//			
//			empObj.put("Name", "Vaibhav Singh Chauhan");
//			empObj.put("Designation", "Trainee Software Engineer");
//			empObj.put("Pay", "Rs. 22000/-");
//
//			phoneNumbers = new JSONArray();
//			phoneObj = new JSONObject();
//			phoneObj.put("LandLine", "0512-2545865");
//			phoneObj.put("Mobile", "8707645427");
//			phoneNumbers.put(phoneObj);
//
//			empObj.put("PhoneNumbers", phoneNumbers);
//
//			empArray.put(empObj);
//
//			empObj = new JSONObject();
//			empObj.put("Name", "Sachit Mohan Gupta");
//			empObj.put("Designation", "IOT Consultant");
//			empObj.put("Pay", "Rs. 60000/-");
//
//			phoneNumbers = new JSONArray();
//			phoneObj = new JSONObject();
//			phoneObj.put("LandLine", "022-2548796");
//			phoneObj.put("Mobile", "9920709687");
//			phoneNumbers.put(phoneObj);
//
//			empObj.put("PhoneNumbers", phoneNumbers);
//
//			empArray.put(empObj);
//
//			allEmps.put("Employees", empArray);
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		try {
//
//			// Writing to a file
//			FileWriter file = new FileWriter(fileName);
//			file.write(allEmps.toString());
//			file.flush();
//			file.close();
//
//			System.out.println("HURRAYY!!!! JSON FILE CREATED");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	 public String getJsonString() {
		 
	        Connection connection = ConnectionHandler.getConnectionInstance();
	         
	        String jsonString = "";
	        JSONObject jsonobject = null;
	        JSONArray jsonArray = new JSONArray();
	        
	         
	        try {
	            PreparedStatement prepareStatement = connection.prepareStatement(
	 
	                    "SELECT " + "  user_id AS userid,"
	                    + "  user_name AS name,"
	                    + "  DATE_FORMAT(user_dob,'%d/%m/%Y') AS dob,"
	                    + "  user_phone_no AS phoneNo,"
	                    + "  user_email AS email "
	                    + "FROM " + "  user_table "
	 
	            );
	 
	            ResultSet resultSet = prepareStatement.executeQuery();
	 
	            while (resultSet.next()) {
	 
	                ResultSetMetaData metaData = resultSet.getMetaData();
	                jsonobject = new JSONObject();
	 
	                for (int i = 0; i < metaData.getColumnCount(); i++) {
	 
	                    try {
							jsonobject.put(metaData.getColumnLabel(i + 1),resultSet.getObject(i + 1));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	 
	                }
	 
	                jsonArray.put(jsonobject);
	            }
	 
	            if (jsonArray.length() > 0) {
	             
	                jsonString= jsonArray.toString();
	                 
	            }
	 
	     
	            try {
	            	
            			//	Writing to a file
            				FileWriter file = new FileWriter("d:\\db2json.json");
            				file.write(jsonString);
            				file.flush();
            				file.close();
	            	
            				System.out.println("HURRAYY!!!! JSON FILE CREATED");
            			} catch (IOException e) {
           				e.printStackTrace();
            			}
	            System.out.println(jsonString);
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if(connection!=null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return jsonString;
	    }
	 
	
}
