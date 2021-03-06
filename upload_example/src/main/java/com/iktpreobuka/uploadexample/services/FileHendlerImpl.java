package com.iktpreobuka.uploadexample.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class FileHendlerImpl implements FileHendler {
	
	//Save the uploades file to this folder
	private static String UPLOADED_FOLDER = "E://kurs//";

	@Override
	public String singleFileUpload(MultipartFile file, RedirectAttributes redirectAttributes) 
			throws IOException {
		// TODO Auto-generated method stub
		 if (file.isEmpty()) { 
			 redirectAttributes.addFlashAttribute("message", "Please select a file to upload"); 
			 return "redirect:uploadStatus";    
	     } 
		 try {  
	            // Get the file and save it somewhere 
			 byte[] bytes = file.getBytes();   
			 Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename()); 
			 Files.write(path, bytes);  
			 
	            redirectAttributes.addFlashAttribute("message", 
	            		"You successfully uploaded '" + file.getOriginalFilename() + "'");  
	        } catch (IOException e) {     
	        	throw e;     
	        	}
		return "redirect:/uploadStatus";
	}
	
	

}
