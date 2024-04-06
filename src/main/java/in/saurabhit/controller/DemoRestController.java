package in.saurabhit.controller;

import java.util.logging.Logger;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.saurabhit.exception.ExceptionInfo;

@RestController
public class DemoRestController {
	
	//private Logger logger = LoggerFactory.getLogger(DemoRestController.class);
	
	@GetMapping("/")
	public String getMsg() {
		String msg = "Go Home";
		try {
		int i = 10/0;
		}catch(Exception e) {
			e.printStackTrace();
			throw new ArithmeticException(e.getMessage());
		}
		
		return msg;
	}
     
	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<ExceptionInfo> handleAE(ArithmeticException ae){
		
		ExceptionInfo exe = new ExceptionInfo();
		exe.setMsg(ae.getMessage());
		exe.setCode("AIFH56");
		return new ResponseEntity<>(exe,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
