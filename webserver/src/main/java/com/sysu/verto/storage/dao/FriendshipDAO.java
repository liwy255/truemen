package com.sysu.verto.storage.dao;

import com.sysu.verto.storage.model.Friendship;
import java.util.List;

public interface FriendshipDAO {
    List<Friendship> findFriendsByWeChatOrPhone(String identifier);
}
