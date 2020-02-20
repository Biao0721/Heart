package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.R;

import java.util.List;
import java.util.Map;

import data.SuggestData;

public class SuggestAdapter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public SuggestAdapter(Context context){
        this.context = context;
        this.data = new SuggestData().getData();
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 主要控件
     * @author DBin Kon
     */
    public final class Widget{
        public TextView suggestHead;  // 推荐标题
        public TextView suggestName;  // 推荐作者
        public TextView suggestTitle; // 作者头衔
        public TextView suggestTest;  // 推荐内容
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
        Widget widget;

        if (view == null){
            widget = new Widget();
            // 实例化组件
            view = layoutInflater.inflate(R.layout.suggest_item, null);
            widget.suggestHead  = view.findViewById(R.id.suggest_head);
            widget.suggestName     = view.findViewById(R.id.suggest_name);
            widget.suggestTitle    = view.findViewById(R.id.suggest_title);
            widget.suggestTest    = view.findViewById(R.id.suggest_text);
            view.setTag(widget);
        }else {
            widget = (Widget) view.getTag();
        }

        // 锁定数据
        widget.suggestHead.setText((String)friend.get("suggest_head"));
        widget.suggestName.setText((String)friend.get("suggest_name"));
        widget.suggestTitle.setText((String)friend.get("suggest_title"));
        widget.suggestTest.setText((String)friend.get("suggest_text"));

        return view;
    }
}
