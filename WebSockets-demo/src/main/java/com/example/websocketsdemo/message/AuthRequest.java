package com.example.websocketsdemo.message;

/**
 * 用户认证请求, 用户认证请求，是需要用户认证响应的
 */
public class AuthRequest implements Message{

    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public AuthRequest setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
