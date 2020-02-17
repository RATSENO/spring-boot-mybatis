package com.bd.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bd.config.FileUploadConfig;
import com.bd.model.common.res.FileUploadRes;

@RestController
public class FileController {
	
	private Path fileLocation = null;
	
	@Autowired
	private FileUploadConfig config;
	
	@PostConstruct
	public void fileUploadDir() {
		this.fileLocation = Paths.get(this.config.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectory(this.fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/uploadFile")
	public FileUploadRes uploadFile(@RequestParam("file")MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path targetLocation = this.fileLocation.resolve(fileName);
		try {
			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile")
				.path(fileName)
				.toUriString();
		return new FileUploadRes(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<UrlResource> downloadFile(@PathVariable String fileName, HttpServletRequest httpServletRequest){
		Path filePath = this.fileLocation.resolve(fileName).normalize();
		UrlResource resource = null;
		
		String contentType = null;
		try {
			resource = new UrlResource(filePath.toUri());
			contentType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
	}
}
