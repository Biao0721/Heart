package fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo.Login;
import com.example.demo.R;
import com.example.demo.Suggest;

import adapter.SuggestAdapter;

public class Pet extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pet, container, false);
        listView = view.findViewById(R.id.suggest);
        listView.setAdapter(new SuggestAdapter(getActivity()));
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle bundle = new Bundle();
        bundle.putInt("num", i);
        Intent intent= new Intent();
        intent.setClass(getActivity(), Suggest.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
