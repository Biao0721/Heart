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

import com.example.demo.ChatContent;
import com.example.demo.R;

import adapter.FriendAdapter;

public class Chat extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat, container, false);
        listView = view.findViewById(R.id.friend_list);
        listView.setAdapter(new FriendAdapter(getActivity()));
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // 传输数据
        Bundle bundle = new Bundle();
        bundle.putInt("num", i);
        Intent intent= new Intent();
        intent.setClass(getActivity(), ChatContent.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
