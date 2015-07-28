package com.baidu.android.voicedemo;

import java.util.ArrayList;
import java.util.List;

import com.baidu.speech.recognizerdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends Activity {

	private ListView msgListView;

	private EditText inputText;

	private Button send;

	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chat);
		initMsgs();//初始化时加入的几句问候语
		adapter = new MsgAdapter(ChatActivity.this, R.layout.msg_item, msgList);

		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);

		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);//添加新消息
					Msg msg2 = new Msg("我是哑巴~~", Msg.TYPE_RECEIVED);
					msgList.add(msg2);
					adapter.notifyDataSetChanged();//当有新消息时，刷新ListView中的显示
					msgListView.setSelection(msgList.size());//将ListView定位到最后一行
					inputText.setText("");
				}
			}
		});
	}

	private void initMsgs() {
		Msg msg1 = new Msg("主人你好，我是哆啦A梦，请问有什么可以效劳的吗？", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
//		Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
//		msgList.add(msg2);
//		Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
//		msgList.add(msg3);
	}

}
