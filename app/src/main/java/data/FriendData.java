package data;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendData {
    private int[] headImgRes;
    private String[] usernames;
    private String[] lastMsgs;
    private String[] lastMsgTimes;
    private String[] isReads;

    private List<Map<String, Object>> data = new ArrayList<>();

    private void setData(){
         // 用户头像
        headImgRes = new int[]{
                R.drawable.head_image_1, R.drawable.head_image_2,
                R.drawable.head_image_3, R.drawable.head_image_4,
                R.drawable.head_image_5, R.drawable.head_image_6,
                R.drawable.head_image_7, R.drawable.head_image_8,
                R.drawable.head_image_9, R.drawable.head_image_10};

        // 用户昵称
        usernames = new String[]{
                "KikiCaq", "Xiao.D", "鲸落故里",
                "nienieeeee", "s-like_you", "Biao",
                "AhuFiona", "Fiona", "皮皮", "4EVER"};

        //最新消息
        lastMsgs = new String[]{
                "你真棒！", "加油！你可以的", "男神你好帅！", "嘿嘿嘿嘿嘿...",
                "Fight...", "你能到大的，比想象...", "冲冲冲!",
                "[Video Call]", "什么东西？", "[Audio]"};

        // 消息时间
        lastMsgTimes = new String[]{
                "17:40", "10:56", "7月26日",
                "昨天", "7月27日", "09:46",
                "7月18日", "星期一", "7月26日", "4月23日"};

        // 未读消息
        isReads = new String[]{"0", "3", "0", "1", "5", "1", "2", "0", "3", "3"};

        for(int i = 0; i < usernames.length; i++){
            Map<String, Object> showItem = new HashMap<>();
            showItem.put("user_head_image",  headImgRes[i]);     // 用户头像
            showItem.put("user_head_unread", isReads[i]);        // 未读消息
            showItem.put("friend_name",      usernames[i]);      // 用户昵称
            showItem.put("friend_lastmsg",   lastMsgs[i]);       // 最新消息
            showItem.put("friend_time",      lastMsgTimes[i]);   // 消息时间
            data.add(showItem);
        }
    }

    public List<Map<String, Object>> getData(){
        return data;
    }

    public Map<String, Object> getFriendData(int i){
        return data.get(i);
    }

    public FriendData(){
        setData();
    }

}
