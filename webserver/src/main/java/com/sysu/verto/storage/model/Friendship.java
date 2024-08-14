package com.sysu.verto.storage.model;

import java.sql.Timestamp;

public class Friendship {
    private int userID1;
    private int userID2;
    private Timestamp createdAt;

    public Friendship(int userID1, int userID2, Timestamp createdAt) {
        this.userID1 = userID1;
        this.userID2 = userID2;
        this.createdAt = createdAt;
    }

    public int getUserID1() {
        return userID1;
    }

    public void setUserID1(int userID1) {
        this.userID1 = userID1;
    }

    public int getUserID2() {
        return userID2;
    }

    public void setUserID2(int userID2) {
        this.userID2 = userID2;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
