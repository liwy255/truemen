package com.sysu.verto.storage.controller;

import com.sysu.verto.storage.model.Friendship;
import com.sysu.verto.storage.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @GetMapping("/friends")
    public List<Friendship> getFriends(@RequestParam String identifier) {
        return friendshipService.getFriends(identifier);
    }
}
