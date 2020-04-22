package com.modori.smartclassna.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.modori.smartclassna.R;
import com.modori.smartclassna.Retrofit.INodeJS;
import com.modori.smartclassna.Retrofit.RetrofitJWT;
import com.modori.smartclassna.model.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainProduct_stu extends AppCompatActivity {

    BottomNavigationView btmNav;


    private INodeJS myAPIJWT;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private String temptoken, token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_mainproduct);

        //Init API
        Retrofit retrofitJWT = RetrofitJWT.getInstanceJWT();
        myAPIJWT = retrofitJWT.create(INodeJS.class);


        Intent intent = getIntent();
        temptoken = intent.getStringExtra("temptoken");

        transformJWT(temptoken);

        Log.d("test  토큰 결과", temptoken);


        btmNav = findViewById(R.id.btm_nav_stu);


        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.goProjectList_stu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new Projects_stu()).commit();
                        return true;

                    case R.id.goWithMentor_stu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new WithMentor_stu()).commit();
                        return true;

                    case R.id.goBoard_stu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new Board_stu()).commit();
                        return true;
                    case R.id.goMyPage_stu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new MyPage_stu()).commit();
                        return true;

                    default:
                        return false;
                }
            }
        });


    }


    private void ubuntu() {
        String[] parts = token.split("\"");
//
//        User.name = parts[11];
//        User.school = parts[15];
//        User.email = parts[19];
//        User.area = parts[23];
//        User.subject = parts[27];
//        User.detailsubject = parts[31];
//        User.permission = parts[35];
//        User.project = parts[39];


    }

    private void transformJWT(String temptoken) {

        compositeDisposable.add(myAPIJWT.transformJWT(temptoken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                               @Override
                               public void accept(String s) throws Exception {

                                   Log.d("test", "json : " + s);
                                   token = s;

                                   Log.d("test", token);

                                   ubuntu();

                               }
                           }
                ));

    }

}
