package com.ai.example.Controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class ChatController {
	
	@Autowired
	private OllamaChatModel client;
	
	//http://localhost:8080/ai/prompt/what+is+your+name
	@GetMapping("/prompt/{msg}")
	String promptResponse(@PathVariable("msg") String msg)
	{
		return client.call(msg);	
	}
	
	@GetMapping("/prompting")
	String promptingResponse(@RequestParam("msg") String msg)
	{
		return client.call(msg);
	}
	
	@RequestMapping("/hommie")
	public String helloPage()
	{
		//return "Hello from the trader's world!!! welcome to the journey so far, here I'm sitting at 1 Million USD";
		
//		String val = request.getParameter("value");
		
//		HttpSession session = request.getSession();
//		session.setAttribute("val", val);
		
		System.out.println("In home Controller...");
				
		return "home";
	}
}
