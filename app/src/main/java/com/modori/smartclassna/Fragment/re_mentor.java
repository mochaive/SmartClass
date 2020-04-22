package com.modori.smartclassna.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.modori.smartclassna.R;
import com.modori.smartclassna.RegisterActivity;

public class re_mentor extends Fragment {

    View view;

    public static EditText emailEditText, pwEditText, nameEditText, areaEditText, schoolEditText, subjectEditText, detailSubjectEditText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.re_mentor, container, false);

        emailEditText = view.findViewById(R.id.editText_email);
        pwEditText = view.findViewById(R.id.editText_pw);
        nameEditText = view.findViewById(R.id.editText_name);
        areaEditText = view.findViewById(R.id.editText_area);
        subjectEditText = view.findViewById(R.id.editText_subject);
        detailSubjectEditText = view.findViewById(R.id.editText_detailSubject);


        return view;
    }


    public static void mentorRegister() {

        RegisterActivity.email = emailEditText.getText().toString();
        RegisterActivity.pw = pwEditText.getText().toString();
        RegisterActivity.name = nameEditText.getText().toString();
        RegisterActivity.area = areaEditText.getText().toString();
        RegisterActivity.school = null;
        RegisterActivity.subject = subjectEditText.getText().toString();
        RegisterActivity.detailsubject = detailSubjectEditText.getText().toString();

    }
}