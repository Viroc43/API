package com.test;


import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoint;
import com.pojo.PojoMain;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class OMRBranchclub extends BaseClass{
	Response resp;
	
	@Test
	private void login() throws FileNotFoundException, IOException {
		
		// Header
		
		addHead("Content-Type","application/json");
		
		//Basic Auth
		
		basAuth(getproperty("username"),getproperty("password"));
		
		//req Type
		
		reqTy("POST", Endpoint.LOGIN);
		
		
		
		int st = intstat(resp);
		System.out.println(st);
		
		Assert.assertEquals(st, 200, "verified status");
		
		PojoMain pm = resp.as(PojoMain.class);
		
		String m = pm.getMessage();
		System.out.println(m);
		
		Object o = pm.getData().getDevice_token();
		System.out.println(o);
		
		String bd = getBodyAsPrettyString(resp);
		System.out.println(bd);
	
	
		String fn = pm.getData().getFirst_name();
		Assert.assertEquals(fn, 200, "first name verified");
		
	
	}	
		@Test(priority=2)
		private void createaddress() {
		//header
	List<Header>h=new ArrayList<Header>();		
Header h1 =new Header("Content-Type","application/json");
Header h2 =new Header("Authorization","Bearer ");
h.add(h1);
h.add(h2);

Headers headers= new Headers(h)
		
		
		
		}
		}
		
		
		
		
		
		
		
		
		
		
	