package com.chatbot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @PostMapping
    public ResponseEntity<?> receiveMessage(@RequestBody Map<String, Object> payload) {
        try {
            List<Map<String, Object>> entry = (List<Map<String, Object>>) payload.get("entry");
            if (entry != null && !entry.isEmpty()) {
                Map<String, Object> changes = (Map<String, Object>) ((List<?>) entry.get(0).get("changes")).get(0);
                Map<String, Object> value = (Map<String, Object>) changes.get("value");
                List<Map<String, Object>> messages = (List<Map<String, Object>>) value.get("messages");

                if (messages != null && !messages.isEmpty()) {
                    Map<String, Object> msgData = messages.get(0);
                    String from = (String) msgData.get("from");
                    String body = msgData.get("text") != null
                            ? (String) ((Map<?, ?>) msgData.get("text")).get("body")
                            : null;

                    System.out.println("✅ Message received from: " + from);
                    System.out.println("💬 Text: " + body);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Message received");
    }

    @GetMapping
    public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.challenge") String challenge,
                                                @RequestParam("hub.verify_token") String token) {
        if ("subscribe".equals(mode) && "your-verify-token".equals(token)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
