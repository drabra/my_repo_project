package com.iktpreobuka.myfirstproject.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
	
	@RequestMapping("/")
	public String hello() {
		return "Moja prva aplikacija";
	}
	
	@RequestMapping("/date")
	public String date() {
		DateFormat dateformat = new SimpleDateFormat("yyyy/mm/dd");	
		Date date = new Date();
		return dateformat.format(date);
}
	
	@RequestMapping ("/family")
	public List<String> family() {
		List<String> lst = new ArrayList<String>();
		lst.add("Dragana");
		lst.add("Aleksandar");
		return lst;
	}
	@RequestMapping ("/myclass")
	public String myClass() {
		String html =  "<html><h1>Moja grupa</h1><br></br><table><tr><td>Vladimir</td><td>Dimitrieski</td></tr><tr><td>Milan</td><td>Celikovic</td></tr></table></html>";
				return html;
	}
	
	
}