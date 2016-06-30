package com.almond.ourproject.main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.almond.ourproject.common.service.MailSender;
import com.almond.ourproject.main.service.MainService;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());
	private MailSender mailSender = new MailSender();
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value = "/main.do")
	public ModelAndView main(@RequestParam HashMap<String, Object> param) {
		ModelAndView mv = new ModelAndView("main/main");
		
		HashMap<String, Object> map = mainService.test(param);
		
		System.out.println(map);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/sendMail.do")
	public ModelAndView sendMail(@RequestParam HashMap<String, Object> param) {
		ModelAndView mv = new ModelAndView("main/main");
		
		HashMap<String, Object> mail = new HashMap<String, Object>();
		mail.put("target", "dlcndaks12@naver.com");
		mail.put("subject", "제목이당");
		mail.put("content", "내용이당");
		
		mailSender.sendMail(mail);
		
		return mv;
	}
	
	@RequestMapping(value = "/fileUpload.do")
	public ModelAndView fileUpload(@RequestParam HashMap<String, Object> param) throws AmazonServiceException, AmazonClientException, FileNotFoundException {
		
		ModelAndView mv = new ModelAndView("main/main");
		
		System.out.println(param.get("file"));
		
		
		
		return mv;
	}
}
