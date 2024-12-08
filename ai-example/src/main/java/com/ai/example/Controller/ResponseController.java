package com.ai.example.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ResponseController {
	 

	    @PostMapping
	    public ResponseEntity<Map<String, String>> getReply(@RequestBody Map<String, String> request) {
	        String userMessage = request.get("message");

	        // Simulate an AI response (replace with actual logic)
	        String reply = "You said: " + userMessage;

	        Map<String, String> response = new HashMap<>();
	        response.put("index", reply);

	        return ResponseEntity.ok(response);
	    }
	    
//	    @PostMapping("/check")
//	    public ResponseEntity<Map<String, String>> getInput(@RequestBody Map<String, String> req)
//	    {
//	    	String msg = req.get("message");
//	    	//String reply = 
//	    	System.out.println("msg: "+msg);
//	    	Map<String, String> response = new HashMap<>();
//	    	response.put();
//	    	
//	    	return ResponseEntity.ok(response);
//	    	
//	    }
	    
	    @GetMapping("/userdashboard")
		public String userdashboardLogin()
		{
	    	System.out.println("INSIDE userdashboard...");
			return "dashboard";
		}
	}



