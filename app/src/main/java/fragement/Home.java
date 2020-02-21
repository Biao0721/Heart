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

public class Home extends Fragment {
    private TextView homeName;
    private TextView homeGander;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        homeName = view.findViewById(R.id.home_user_name);
        homeGander = view.findViewById(R.id.home_user_gender);

        homeName.setText(Login.userItem.getUserName());
        homeGander.setText(Login.userItem.getGender());

        return view;
    }
}
