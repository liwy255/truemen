package com.sysu.verto.storage.dao.impl;

import com.sysu.verto.storage.dao.FriendshipDAO;
import com.sysu.verto.storage.model.Friendship;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FriendshipDAOImpl implements FriendshipDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Friendship> findFriendsByWeChatOrPhone(String identifier) {
        String sql = "SELECT * FROM Friendship WHERE UserID1 IN " +
                "(SELECT UserID FROM User WHERE WeChatID = ? OR PhoneNumber = ?)";
        return jdbcTemplate.query(sql, new Object[]{identifier, identifier},
                (rs, rowNum) -> new Friendship(
                        rs.getInt("UserID1"),
                        rs.getInt("UserID2"),
                        rs.getTimestamp("CreatedAt")
                ));
    }
}
