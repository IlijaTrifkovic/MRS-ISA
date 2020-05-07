package com.mrsisa.service.mail;

public class HtmlResponse {
public static final String CLIENT_URL="http://localhost:4445/";
	
	private HtmlResponse() {
	}

	public static String HTML_RESPONSE(String response) {
		return  "<html><head><title>KliničkiCentar</title><meta charset=\"utf-8\">"
				+"</head><body><h1>"+response+"</h1>"
				+"<a href=\""+CLIENT_URL+"\">"+CLIENT_URL+"</a>"
				+"<style> body,html{margin: 0; font-family: Segoe UI;}"
				+"h1{ position: relative; width: 100%; color:white;"
	            +"background-color: rgb(15, 146, 113); margin: 0; padding: 6px;"
	            +"text-align: center; } a{ margin-top: 15px; position: relative;"
	            +"text-align: center; display: block;} </style></body></html>";
	}
}
