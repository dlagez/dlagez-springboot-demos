package com.example.websocketsdemo.handler;

import com.example.websocketsdemo.message.AuthRequest;
import com.example.websocketsdemo.message.AuthResponse;
import com.example.websocketsdemo.message.UserJoinNoticeRequest;
import com.example.websocketsdemo.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.Session;

@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {
    @Override
    public void execute(Session session, AuthRequest message) {
        if (StringUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    new AuthResponse().setCode(1).setMessage("认证 accessToken 未传入"));
            return;
        }

        // 添加到 WebSocketUtil 中
        // 考虑到代码简化，我们先直接使用 accessToken 作为 User
        WebSocketUtil.addSession(session, message.getAccessToken());
        System.out.println("假装认证成功");
        // 判断是否认证成功，这里假装成功
        WebSocketUtil.send(session, AuthRequest.TYPE, new AuthResponse().setCode(0));

        System.out.println("广播：。。。nihao");
        // 通知所有人，某个人加入了，
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE,
                new UserJoinNoticeRequest().setNickname(message.getAccessToken()));
    }

    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }
}
