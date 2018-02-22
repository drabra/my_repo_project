package com.iktpreobuka.uploadexample.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface FileHendler {
	public String singleFileUpload(
	MultipartFile file, RedirectAttributes
	redirectAttributes) throws IOException;

}
