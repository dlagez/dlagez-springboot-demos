package com.example.websocketsdemo.websocket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.websocketsdemo.handler.MessageHandler;
import com.example.websocketsdemo.message.AuthRequest;
import com.example.websocketsdemo.message.Message;
import com.example.websocketsdemo.util.WebSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller  // 保证创建一个 WebsocketServerEndpoint Bean 。
@ServerEndpoint("/")  // 标记这是一个 WebSocket EndPoint ，路径为 / 。
public class WebsocketServerEndpoint implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 消息类型与MessageHandler的映射
     */
    private static final Map<String, MessageHandler> HANDLERS = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 实现连接时，使用 accessToken 参数进行用户认证
     * @param session
     * @param config
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("[onOpen][session({}) 接入]", session);
        // 解析 accessToken
        // 解析 ws:// 地址上的 accessToken 的请求参。例如说：ws://127.0.0.1:8080?accessToken=RocZhang
        List<String> accessTokenValues = session.getRequestParameterMap().get("accessToken");
        String accessToken = !CollectionUtils.isEmpty(accessTokenValues) ? accessTokenValues.get(0) : null;

        // 创建AuthRequest 消息类型
        // 创建 AuthRequest 消息类型，并设置 accessToken 属性。
        AuthRequest authRequest = new AuthRequest().setAccessToken(accessToken);

        // 获取消息处理器
        // 获得 AuthRequest 消息类型对应的 MessageHandler 消息处理器，然后调用
        MessageHandler<AuthRequest> messageHandler = HANDLERS.get(AuthRequest.TYPE);
        if (messageHandler == null) {
            logger.error("[onOpen][认证消息类型，不存在消息处理器]");
            return;
        }
        messageHandler.execute(session, authRequest);

    }

    /**
     * 接收消息
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info("[onMessage][session({}) 接收到一条消息({})]", session, message);
        try {
            // 获得消息类型
            JSONObject jsonMessage = JSON.parseObject(message);
            String messageType = jsonMessage.getString("type");
            // 获得消息处理器
            MessageHandler messageHandler = HANDLERS.get(messageType);
            if (messageHandler == null) {
                logger.error("[onMessage][消息类型({}) 不存在消息处理器]", messageType);
                return;
            }

            Class<? extends Message> messageClass = this.getMessageClass(messageHandler);
            Message messageObj = JSON.parseObject(jsonMessage.getString("body"), messageClass);
            messageHandler.execute(session, messageObj);
        } catch (Throwable throwable) {
            logger.info("[onMessage][session({}) message({}) 发生异常]", session, throwable);
        }

    }

    private Class<? extends Message> getMessageClass(MessageHandler handler) {
        // 获取Bean对应的 Class 类名， 因为有可能被AOP代理过
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(handler);
        // 获得接口的Type 数组
        Type[] interfaces = targetClass.getGenericInterfaces();
        Class<?> superclass = targetClass.getSuperclass();
        while ((Objects.isNull(interfaces) || 0 == interfaces.length) && Objects.nonNull(superclass)) {
            interfaces = superclass.getGenericInterfaces();
            superclass = targetClass.getSuperclass();
        }

        if (Objects.nonNull(interfaces)) {
            // 遍历interfaces数组
            for (Type type : interfaces) {
                ParameterizedType parameterizedType = (ParameterizedType)type;

                if (Objects.equals(parameterizedType.getRawType(), MessageHandler.class)) {
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (Objects.nonNull(actualTypeArguments) && actualTypeArguments.length > 0) {
                        return (Class<Message>) actualTypeArguments[0];
                    } else {
                        throw new IllegalStateException(String.format("类型(%s)获得不到类型消息", handler));
                    }
                }
            }
        }
        throw new IllegalStateException(String.format("类型(%s)获得不到类型消息", handler));
    }



    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("[onClose][session({}) 链接关闭。关闭原因是({})]", session, closeReason);
        WebSocketUtil.removeSession(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.info("[onClose][session({}) 发生异常]", session, throwable);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        // 获得所有 MessageHandler Bean
        applicationContext.getBeansOfType(MessageHandler.class).values()
                .forEach(messageHandler -> HANDLERS.put(messageHandler.getType(), messageHandler)); // 添加到 handlers 中
        logger.info("[afterPropertiesSet][消息处理器数量: {}]", HANDLERS.size());
    }
}
