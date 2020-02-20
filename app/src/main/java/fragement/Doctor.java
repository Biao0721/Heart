package fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class Doctor extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.doctor, container, false);
        listView = view.findViewById(R.id.doctor_list);
        listView.setAdapter(new DoctorAdapter(getActivity()));

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        // 传输数据
//        Bundle bundle = new Bundle();
//        bundle.putInt("num", i);
//        Intent intent= new Intent();
//        intent.setClass(getActivity(), ChatContent.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }
}
