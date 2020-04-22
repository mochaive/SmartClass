package com.modori.smartclassna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.modori.smartclassna.Fragment.re_mentor;
import com.modori.smartclassna.Fragment.re_student;
import com.modori.smartclassna.Fragment.re_teacher;
import com.modori.smartclassna.Retrofit.INodeJS;
import com.modori.smartclassna.Retrofit.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button openStudent, openTeacher, openMentor;
    FrameLayout mainFrame;

    Button registerButton;


    public static String email, pw, name, area, school, subject, detailsubject;
    String permission = "S";


    private INodeJS myAPIAuth;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initWork();


        //Init API
        Retrofit retrofitAuth = RetrofitClient.getInstanceAuth();
        myAPIAuth = retrofitAuth.create(INodeJS.class);


        registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (permission.equals("S")) {

                    re_student.studentRegister();


                } else if (permission.equals("T")) {

                    re_teacher.teacherRegister();


                } else if (permission.equals("M")) {

                    re_mentor.mentorRegister();


                } else {

                }

                registerUser();

            }
        });


    }

    private void registerUser() {
        compositeDisposable.add(myAPIAuth.registerUser(email, pw, name, area, school, subject, detailsubject, permission)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                               @Override
                               public void accept(String s) throws Exception {
                                   Toast.makeText(RegisterActivity.this, "" + s, Toast.LENGTH_SHORT).show();

                                   Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                   startActivity(intent);

                                   finish();
                               }
                           }
                ));
    }

    private void initWork() {
        openStudent = findViewById(R.id.openStudentTab);
        openTeacher = findViewById(R.id.openTeacherTab);
        openMentor = findViewById(R.id.openMentorTab);

        openStudent.setOnClickListener(this);
        openTeacher.setOnClickListener(this);
        openMentor.setOnClickListener(this);

        mainFrame = findViewById(R.id.mainFrame);

        openStudent.setSelected(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new re_student()).commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openStudentTab:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new re_student()).commit();
                openStudent.setSelected(true);
                openTeacher.setSelected(false);
                openMentor.setSelected(false);
                permission = "S";

                break;
            case R.id.openTeacherTab:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new re_teacher()).commit();
                openTeacher.setSelected(true);
                openStudent.setSelected(false);
                openMentor.setSelected(false);
                permission = "T";


                break;
            case R.id.openMentorTab:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new re_mentor()).commit();
                openMentor.setSelected(true);
                openStudent.setSelected(false);
                openTeacher.setSelected(false);
                permission = "M";


                break;

            default:
                break;
        }
    }
}