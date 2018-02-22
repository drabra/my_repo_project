package com.iktpreobuka.firstprojectvezba.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@RequestMapping("/family")
	public List<String> family() {
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("Dragana");
		lst.add("Aleksandar");
		return lst;
	}

	@RequestMapping("/myclass")
	public String myClass() {
		String html = "<html><h1>Moja grupa</h1><br></br><table><tr><td>Vladimir</td><td>Dimitrieski</td></tr><tr><td>Milan</td><td>Celikovic</td></tr></table></html>";
		return html;
	}
	
	@RequestMapping("/array")
	public List<Integer> array(){
		List<Integer> array = new ArrayList<Integer>();
		array.add(2);
		array.add(4);
		array.add(8);
		array.add(10);
		array.add(6);
		array.add(11);
		return array;
	}
	
	@RequestMapping("/sortarray")
	public List<Integer> sortarray() {
		List<Integer> array = new ArrayList<Integer>();
		array.add(2);
		array.add(4);
		array.add(8);
		array.add(10);
		array.add(6);
		array.add(11);
		Collections.sort(array);
		return array;
	}
	
	@RequestMapping("/minmax")
	public int[] minmax() {
	    List<Integer> array = new ArrayList<Integer>();
	    array.add(2);
		array.add(4);
		array.add(8);
		array.add(10);
		array.add(6);
		array.add(11);
		int[] minmax = { Collections.min(array), Collections.max(array)};
		return minmax;
	}

		
		
		

}
