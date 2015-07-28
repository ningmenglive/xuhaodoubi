package com.baidu.android.voicedemo;

import java.util.List;

import com.baidu.speech.recognizerdemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;

	public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Msg msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		ImageView leftPhotoView;
		ImageView rightPhotoView;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view
					.findViewById(R.id.left_layout);

			viewHolder.leftchildLayout = (LinearLayout) view
					.findViewById(R.id.left_childlayout);

			viewHolder.rightLayout = (LinearLayout) view
					.findViewById(R.id.right_layout);

			viewHolder.rightchildLayout = (LinearLayout) view
					.findViewById(R.id.right_childlayout);

			viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
			leftPhotoView = (ImageView) view
					.findViewById(R.id.message_friend_userphoto);
			rightPhotoView = (ImageView) view
					.findViewById(R.id.message_user_userphoto);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		if (msg.getType() == Msg.TYPE_RECEIVED) {
			//设置左侧头像、聊天框可见
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);

			viewHolder.leftchildLayout.setVisibility(View.VISIBLE);
			viewHolder.rightchildLayout.setVisibility(View.GONE);

			viewHolder.leftMsg.setText(msg.getContent());
		} else if (msg.getType() == Msg.TYPE_SENT) {
			//设置右侧头像、聊天框可见
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightchildLayout.setVisibility(View.VISIBLE);
			viewHolder.leftchildLayout.setVisibility(View.GONE);
			viewHolder.rightMsg.setText(msg.getContent());
		}
		return view;
	}

	class ViewHolder {

		LinearLayout leftLayout;

		LinearLayout rightLayout;

		LinearLayout leftchildLayout;

		LinearLayout rightchildLayout;

		TextView leftMsg;

		TextView rightMsg;

	}

}
