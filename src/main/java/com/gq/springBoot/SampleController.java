package com.gq.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

/** 
* @className:SampleController.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-9-30
*/
@Controller
@EnableAutoConfiguration
public class SampleController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SampleController.class, args);
	}
}
