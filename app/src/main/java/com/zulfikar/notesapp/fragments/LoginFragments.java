package com.zulfikar.notesapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.zulfikar.notesapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragments extends Fragment {

    private OnLoginFragmentListener listener;

    public LoginFragments() {
        // Required empty public constructor
    }

    public void setListener(OnLoginFragmentListener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_login, container, false);
        final TextView usernameText = view.findViewById(R.id.text_username);
        final TextView passwordText = view.findViewById(R.id.text_password);
        Button loginButton = view.findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                listener.onLoginClicked(view, username, password);
            }
        });

        return  view;
    }

    public interface OnLoginFragmentListener{
        void onLoginClicked(View view, String username, String password);
    }

}