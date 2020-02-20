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

import data.DoctorData;

public class DoctorAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public DoctorAdapter(Context context){
        this.context = context;
        this.data = new DoctorData().getData();
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 主要控件
     * @author DBin Kon
     */
    public final class Widget{
        public ImageView doctorHeadImg;      // 医生头像
        public TextView  doctorName;         // 医生信息
        public TextView  doctorFirld;        // 擅长领域
        public TextView  doctorInformation;  // 详细描述
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
        Map<String, Object> doctor = data.get(i);
        Widget widget;
        if (view == null){
            widget = new Widget();
            // 实例化组件
            view = layoutInflater.inflate(R.layout.doctor_item, null);
            widget.doctorHeadImg     = view.findViewById(R.id.doctor_head_img);
            widget.doctorName        = view.findViewById(R.id.doctor_name);
            widget.doctorFirld       = view.findViewById(R.id.doctor_field);
            widget.doctorInformation = view.findViewById(R.id.doctor_information);
            view.setTag(widget);
        }else {
            widget = (Widget) view.getTag();
        }

        // 锁定数据
        widget.doctorHeadImg.setBackgroundResource((Integer)data.get(i).get("doctor_head_img"));
        widget.doctorName.setText((String)data.get(i).get("doctor_name"));
        widget.doctorFirld.setText((String)data.get(i).get("doctor_field"));
        widget.doctorInformation.setText((String)data.get(i).get("doctor_information"));
        return view;
    }
}
