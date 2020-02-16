package fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo.Login;
import com.example.demo.R;

public class Pet extends Fragment {
    private TextView userNameTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pet, container, false);
        userNameTV = view.findViewById(R.id.user_name);
        userNameTV.setText(Login.name);

        return view;
    }
}
