package com.softserv.todolist.entity;

/**
 * Created by jarki on 6/17/2017.
 */
public class Item {
    private int itemId;
    private String text;
    private boolean state;
    private int UserId;

    public Item() {
    }

    public Item(String text, boolean state, int userId) {
        this.text = text;
        this.state = state;
        UserId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
