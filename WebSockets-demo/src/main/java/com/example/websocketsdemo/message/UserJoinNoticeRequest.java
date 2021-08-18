package com.example.websocketsdemo.message;

/**
 * 用户成功认证之后，会广播用户加入群聊的通知 Message ，
 * 使用 UserJoinNoticeRequest
 */
public class UserJoinNoticeRequest implements Message{
    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public UserJoinNoticeRequest setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
}
