package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

import java.util.List;
import java.util.Map;

import data.FriendData;

public class FriendAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public FriendAdapter(Context context){
        this.context = context;
        this.data = new FriendData().getData();
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 主要控件
     * @author DBin Kon
     */
    public final class Widget{
        public ImageView friendHeadImg;   // 用户头像
        public TextView  friendunread;    // 未读信息
        public TextView  friendName;      // 用户姓名
        public TextView  firendMsg;       // 用户消息
        public TextView  firendTime;      // 信息时间
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Map<String, Object> friend = data.get(i);
        Widget widget = null;
        if (view == null){
            widget = new Widget();
            // 实例化组件
            view = layoutInflater.inflate(R.layout.friend_item, null);
            widget.friendHeadImg = view.findViewById(R.id.user_head_image);
            widget.friendunread  = view.findViewById(R.id.user_head_unread);
            widget.firendMsg     = view.findViewById(R.id.friend_lastmsg);
            widget.friendName    = view.findViewById(R.id.friend_name);
            widget.firendTime    = view.findViewById(R.id.friend_time);
            view.setTag(widget);
        }else {
            widget = (Widget) view.getTag();
        }

        if(data.get(i).get("user_head_unread") == "0"){
            widget.friendunread.setVisibility(View.GONE);
        }else{
            widget.friendunread.setVisibility(View.VISIBLE);
        }

        // 锁定数据
        widget.friendHeadImg.setImageResource((Integer)friend.get("user_head_image"));
        widget.friendunread.setText((String)friend.get("user_head_unread"));
        widget.friendName.setText((String)friend.get("friend_name"));
        widget.firendMsg.setText((String)friend.get("friend_lastmsg"));
        widget.firendTime.setText((String)friend.get("friend_time"));
        return view;
    }
}
