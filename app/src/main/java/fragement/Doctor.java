package fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.DoctorAdapter;

public class Doctor extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.doctor, container, false);
        listView = view.findViewById(R.id.doctor_list);
        List<Map<String, Object>> data = getData();
        listView.setAdapter(new DoctorAdapter(getActivity(), data));

        return view;
    }

    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> listItem = new ArrayList<>();

        // 医生头像
        int[] doctorHeadImg = {
                R.mipmap.doctor, R.mipmap.doctor, R.mipmap.doctor,
                R.mipmap.doctor, R.mipmap.doctor, R.mipmap.doctor,
                R.mipmap.doctor, R.mipmap.doctor, R.mipmap.doctor};

        // 医生姓名
        String[] doctorName = {
                "阿勇", "猪猪少年队  ", "陈丹丹",
                "曹老师", "Ahu#、Fiona", "刚把",
                "皮皮", "唐小晓", "Doctor"};

        // 擅长领域
        String[] doctorFirld = {
                "1. 心理", "1. 心理", "1. 心理",
                "1. 心理", "1. 心理", "1. 心理",
                "1. 心理", "1. 心理", "1. 心理"};

        // 详细信息
        String[] doctorInformation = {
                "详细信息", "详细信息", "详细信息",
                "详细信息", "详细信息", "详细信息",
                "详细信息", "详细信息", "详细信息"};

        for(int i = 0; i < doctorName.length; i++){
            Map<String, Object> showItem = new HashMap<>();
            showItem.put("doctor_head_img",    doctorHeadImg[i]);       // 医生头像
            showItem.put("doctor_name",        doctorName[i]);          // 医生姓名
            showItem.put("doctor_field",       doctorFirld[i]);         // 擅长领域
            showItem.put("doctor_information", doctorInformation[i]);   // 详细描述
            listItem.add(showItem);
        }

        return listItem;
    }

}
