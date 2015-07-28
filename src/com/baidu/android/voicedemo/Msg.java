package com.baidu.android.voicedemo;

public class Msg {
	//消息类 参数content表示聊天消息，type表示消息发送者机器人or用户
	public static final int TYPE_RECEIVED = 0;

	public static final int TYPE_SENT = 1;

	private String content;

	private int type;

	public Msg(String content, int type) {
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}

}
