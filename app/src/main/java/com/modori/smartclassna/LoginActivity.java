package com.modori.smartclassna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.modori.smartclassna.Retrofit.INodeJS;
import com.modori.smartclassna.Retrofit.RetrofitClient;
import com.modori.smartclassna.student.MainProduct_stu;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    View makeAuthBtn;
    EditText emailEditText, pwEditText;
    Button loginButton;

    private String email, pw;

    private INodeJS myAPIAuth;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    String temptoken;
    String permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Init API
        Retrofit retrofitAuth = RetrofitClient.getInstanceAuth();
        myAPIAuth = retrofitAuth.create(INodeJS.class);




        makeAuthBtn = findViewById(R.id.makeAuthBtn);

        makeAuthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


        emailEditText = findViewById(R.id.editText_id_login);
        pwEditText = findViewById(R.id.editText_pw_login);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = emailEditText.getText().toString();
                pw = pwEditText.getText().toString();
                loginUser(email, pw);



            }
        });

    }

    private void check(){
        if(permission.equals("S")) {

            Intent intent = new Intent(LoginActivity.this, MainProduct_stu.class);
            intent.putExtra("temptoken", temptoken);
            startActivity(intent);
            finish();

        } else if(permission.equals("T")) {


            Intent intent = new Intent(LoginActivity.this, MainProduct_stu.class);
            intent.putExtra("temptoken", temptoken);
            startActivity(intent);
            finish();

        } else if(permission.equals("M")) {


            Intent intent = new Intent(LoginActivity.this, MainProduct_stu.class);
            intent.putExtra("temptoken", temptoken);
            startActivity(intent);
            finish();

        } else {

        }
    }
    private void loginUser(String email, String pw) {
        compositeDisposable.add(myAPIAuth.loginUser(email, pw)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                               @Override
                               public void accept(String s) throws Exception {
                                   Toast.makeText(LoginActivity.this, "" + s, Toast.LENGTH_SHORT).show();

                                   Log.d("test 토큰 결과", "" + s);

                                   String[] parts = s.split("\"");

                                   try{
                                       temptoken = parts[9];
                                       permission = parts[13];
                                   }catch (Exception e){
                                       Toast.makeText(LoginActivity.this,"정보가 알맞지 않거나 문제가 발생했습니다.", Toast.LENGTH_LONG).show();
                                   }


                                   Log.d("test", permission);

                                   check();
                               }
                           }
                ));
    }


}