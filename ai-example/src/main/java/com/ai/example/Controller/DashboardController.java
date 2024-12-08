package com.ai.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.example.dto.FluxMessage;
import com.ai.example.dto.Message;

@Controller
public class DashboardController {
    
    @Autowired
    private OllamaChatModel client;
    
    private List<Message> messages = new ArrayList<>();
    private List<FluxMessage> fluxMessages = new ArrayList<>();
    
    // Display the dashboard with the chat messages
    @GetMapping("/home/dashboard")
    public String getDashboard(Model model) {
        System.out.println("INSIDE getDashboard method...");
        model.addAttribute("messages", messages);
        return "board"; // Resolves to /WEB-INF/views/board.html
    }
    
    @PostMapping("/submit")
    @ResponseBody // Return raw response instead of redirecting
    public String handleUserInput(@RequestParam("userInput") String userInput, Model model) {
        // Add user message
        messages.add(new Message("user", userInput));
        System.out.println("INSIDE handleUserInput method...");
        System.out.println("USER INPUT "+userInput);



        // Generate bot response (no Flux, just a single string response)
        String botResponse = client.call(userInput);
        System.out.println("BOT RESPONSE "+botResponse);


//        // Add bot response to messages
//        messages.add(new Message("bot", botResponse));
//
//        // Pass messages to the model
//        model.addAttribute("messages", messages);

        return botResponse; // Redirect to update the chat view
    }

}
