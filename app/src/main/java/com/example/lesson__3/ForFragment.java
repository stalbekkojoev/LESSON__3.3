package com.example.lesson__3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ForFragment extends Fragment {


    private EditText editText;
    private Button button;
    private static final String KEY = "KEY";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.et_text);
        button = view.findViewById(R.id.btn_go);
        Bundle bundle = getArguments();
        editText.setText(bundle.getString(KEY));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Bundle bundle3 = new Bundle();
                bundle3.putString(KEY, text);
                FiveFragment fragment = new FiveFragment();
                fragment.setArguments(bundle3);
                requireActivity().getSupportFragmentManager().beginTransaction().addToBackStack("")
                        .replace(R.id.layout_fragment, fragment).commit();

            }
        });
    }
}