package com.darkhorse.db2json2xls;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.darkhorse.db2json2xls.pojo.MyPojo;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper =new ObjectMapper();
		

					try {
						MyPojo []myPojo = mapper.readValue(new File("d://db2json.json"), MyPojo[].class);
					//	List<MyPojo> al=Arrays.asList(myPojo);
						for(int i=0;i<myPojo.length;i++) {
						System.out.println(myPojo[i].getUserid());
						System.out.println(myPojo[i].getName());
						System.out.println(myPojo[i].getDob());
						System.out.println(myPojo[i].getEmail());
						System.out.println(myPojo[i].getPhoneNo());
						System.out.println("================================================");
						}
				
						
						
						
						
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		

	}

}
