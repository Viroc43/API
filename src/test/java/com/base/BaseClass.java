package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
Response resp;
RequestSpecification rs;
public void addHead(String key, String value) {
rs = RestAssured.given().header(key, value);
	}
public void queryparam(String key, String value) {
rs = rs.queryParam(key, value);
}
	
public void pathparam(String key, String value) {
rs = rs.pathParam(key, value);
}

public void basAuth(String uNam, String pass) {
rs= rs.auth().preemptive().basic(uNam, pass);

}

public void addBody(String body) {
rs=rs.body(body);
}

public Response reqTy(String reqtype, String endpoint) {
switch (reqtype) {
case "GET":
	resp=rs.get(endpoint);
	break;
case "POST":
	resp=rs.post(endpoint);
	break;
case "PUT":
	resp=rs.put(endpoint);
	break;
case "DELETE":
	resp=rs.delete(endpoint);
	break;

default:
	break;
}
return resp;
}

public int intstat(Response resp) {
int statusCode = resp.getStatusCode();
return statusCode;
}


public ResponseBody getBody(Response resp) {
ResponseBody body = resp.getBody();
return body;
}
public String getBodyAsPrettyString(Response resp) {
	String asString = getBody(resp).asString();
	
	return asString;
	
}



public String getproperty(String key) throws IOException,FileNotFoundException {
	
	Properties p = new Properties();
		
	p.load(new FileInputStream(System.getProperty("user.dir")+"src//test//resources//Config.properties"));
	
	Object o = p.get(key);
	
	String v = (String) o;
	
return v;

}

private void addHeaders(Headers head) {
rs=RestAssured.given().headers(head);
}

private void addBody(Object body) {
	// TODO Auto-generated method stub
rs=rs.body(body);
}


}