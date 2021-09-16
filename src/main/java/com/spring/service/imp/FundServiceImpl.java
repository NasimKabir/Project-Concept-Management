package com.spring.service.imp;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.spring.model.Fund;
import com.spring.model.Sector;
import com.spring.repository.FundRepository;
import com.spring.repository.SectorRepository;
import com.spring.response.HttpResponse;
import com.spring.utility.FileUpload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FundServiceImpl {
	@Value("${file.upload}")
	private String defaultFilePath;
	private final FundRepository fundRepository;

	public ResponseEntity<?> FundInsert( boolean fundType, int agrementNumber, MultipartFile agrementFile) throws Exception {
		Fund fund=new Fund();
		fund.setFundType(fundType);
		fund.setAgrementNumber(agrementNumber);
		FileUpload.uploadFile(agrementFile, defaultFilePath);
		String staticPath = FileUpload.creatStaticPath();
		fund.setAgrementFile(staticPath);
	 fundRepository.save(fund);
		HttpResponse response = new HttpResponse();
		response.setHttpStatusCode(CREATED.value());
		response.setHttpStatus(CREATED);
		response.setMessage("sector  insert Successfull");
		return new ResponseEntity<>(fund, CREATED);
	}
}
