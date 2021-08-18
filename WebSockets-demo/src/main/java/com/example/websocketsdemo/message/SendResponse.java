package com.example.websocketsdemo.message;

/**
 * 在服务端接收到发送消息的请求，需要异步响应发送是否成功
 */
public class SendResponse implements Message{

    public static final String TYPE = "SEND_RESPONSE";

    /**
     * 消息编号
     */
    private String msgId;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应提示
     */
    private String message;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
