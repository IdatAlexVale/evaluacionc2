package com.example.examen3;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class BeginningFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.beginning_fragment,container,false);
        MaterialButton Button = view.findViewById(R.id.btn_login_secion);
        final TextInputLayout textInputLayout = view.findViewById(R.id.login_password_input);
        final TextInputEditText textInputEditText = view.findViewById(R.id.login_password_edit);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isNumberValid(textInputEditText.getText())){
                    textInputLayout.setError(getString(R.string.login_error));
                }else{
                    textInputLayout.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new Home_Frame(),false);
                }
            }
        });

        return view;
    }


    private boolean isNumberValid(@Nullable Editable txt){ return txt != null && txt.length() >5; }
}
