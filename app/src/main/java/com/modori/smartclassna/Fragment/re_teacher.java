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


public class re_teacher extends Fragment {

    View view;


    public static EditText emailEditText, pwEditText, nameEditText, areaEditText, schoolEditText, subjectEditText, detailSubjectEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.re_teacher, container, false);

        emailEditText = view.findViewById(R.id.editText_email);
        pwEditText = view.findViewById(R.id.editText_pw);
        nameEditText = view.findViewById(R.id.editText_name);
        areaEditText = view.findViewById(R.id.editText_area);
        schoolEditText = view.findViewById(R.id.editText_school);
        subjectEditText = view.findViewById(R.id.editText_subject);

        return view;
    }


    public static void teacherRegister() {

        RegisterActivity.email = emailEditText.getText().toString();
        RegisterActivity.pw = pwEditText.getText().toString();
        RegisterActivity.name = nameEditText.getText().toString();
        RegisterActivity.area = areaEditText.getText().toString();
        RegisterActivity.school = schoolEditText.getText().toString();
        RegisterActivity.subject = subjectEditText.getText().toString();
        RegisterActivity.detailsubject = null;

    }


}