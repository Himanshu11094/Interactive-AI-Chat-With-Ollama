package com.ai.example.dto;

import reactor.core.publisher.Flux;

public class FluxMessage {
	
	private String sender;
    private Flux<String> text;

    public FluxMessage(String sender, Flux<String> text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public Flux<String> getText() {
        return text;
    }

}
