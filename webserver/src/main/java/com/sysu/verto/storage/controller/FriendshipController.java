package com.sysu.verto.storage.controller;

import com.sysu.verto.storage.model.Friendship;
import com.sysu.verto.storage.model.Message;
import com.sysu.verto.storage.service.FriendshipService;
import com.sysu.verto.storage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/friends")
    public List<Friendship> getFriends(@RequestParam String identifier) {
        return friendshipService.getFriends(identifier);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam Long userId1, @RequestParam Long userId2) {
        List<Message> messages = messageService.getMessagesBetweenUsers(userId1, userId2);
        return ResponseEntity.ok(messages);
    }

}
