package com.spring.utility;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class FileUpload {

	public static String uploadFile(MultipartFile file,String defaultFilePath)
			throws Exception {

		String filePath = "";
		if (file != null) {
				
				if (file.getOriginalFilename() != null)
					filePath = defaultFilePath + file.getOriginalFilename();
				System.out.println(filePath);
				Path path = Paths.get(filePath);
				 Files.copy(file.getInputStream(), path);
				
		}
		return filePath;
	}

	public static String creatStaticPath() {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/project/fund").toUriString();
	}

}
