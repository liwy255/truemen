package com.sysu.verto.storage.service;

import com.sysu.verto.storage.dao.FriendshipDAO;
import com.sysu.verto.storage.model.Friendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipDAO friendshipDAO;

    public List<Friendship> getFriends(String identifier) {
        return friendshipDAO.findFriendsByWeChatOrPhone(identifier);
    }
}
