package com.darkhorse.db2json2xls;
import org.json.JSONException;

import com.darkhorse.db2json2xls.services.JsonServices;

/**
 * Author : Vaibhav Singh Chauhan
 *
 */
public class Main 
{
	//ResultSet resultSet=null;
	//EmpDAO empdao=new EmpDAO();
	//public List<JSONObject> getJsonObject()
	//{
	//	resultSet=empdao.getResultSet();
	// List<JSONObject> resList=JsonServices.getFormattedResult(resultSet);
	// return resList;
	 
	//}
	
	
	
    public static void main( String[] args )
    {
    	
    	String fileName = "D:\\db2json.json";
    //  Main m=new Main();
      JsonServices js=new JsonServices();
      js.getJsonString();
      
   
   //   List<JSONObject> jObj=m.getJsonObject();
      //for(JSONObject jsonObj :jObj)
   //   for(int i=0;i<jObj.size();i++) 
     // {
    	//  System.out.println(jObj.get(i)+",");
    //  }
    }
}
