package com.modori.smartclassna;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.modori.smartclassna.Api.ApiClient;
import com.modori.smartclassna.model.WordCloud;
import com.modori.smartclassna.student.MainProduct_stu;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrainStorming extends AppCompatActivity {

    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab1, fab2, fab3;
    private Dialog_Brain dialog;

    Button addBtn, getBtn, deleteBtn,sendBtn;
    TextView keywordView;
    ImageView imageView, infoBtn;


    Set<String> keywordLists = new HashSet<>();
    boolean isAdding = true;
    String keywordStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_storming);

        initWork();

        final View mainLayout = findViewById(R.id.mainLayout);


        keywordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mainLayout, "키워드를 입력하시라면 우측 하단의 버튼으로 추가해주세요", Snackbar.LENGTH_LONG).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdding = true;
                dialog.show();
            }
        });

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(0);
                Random random = new Random();
                int a = random.nextInt(100);
                ApiClient.getCloud().getCloud("abcd" + a, getKeywordStr()).enqueue(new Callback<WordCloud>() {
                    @Override
                    public void onResponse(Call<WordCloud> call, Response<WordCloud> response) {
                        if (response.isSuccessful()) {
                            Glide.with(getApplicationContext()).load(response.body().getUrl()).into(imageView);
                        }
                    }

                    @Override
                    public void onFailure(Call<WordCloud> call, Throwable t) {

                    }
                });
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdding = false;
                dialog.show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);

            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("사용방법");
                builder.setMessage("이 페이지의 사용방법 소개");
                builder.setPositiveButton("알겠습니다.",
                        (dialog, which) -> {

                        });

                builder.show();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BrainStorming.this, MainProduct_stu.class));
            }
        });

    }

    private String getKeywordStr() {
        System.out.println(keywordLists.toString());
        StringBuilder builder = new StringBuilder();
        int lastIndex = keywordLists.size() - 1;
        int index = 0;
        for (String value : keywordLists) {
            if (index != lastIndex) {
                builder.append(value).append(", ");

            } else {
                builder.append(value);

            }

            index++;
        }
        return builder.toString();

    }

    private void reloadKeywordView() {
        keywordStr = getKeywordStr();
        keywordView.setText(keywordStr);
    }

    private View.OnClickListener posiBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = dialog.getKeyword();
            //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            if (!str.equals("")) {
                if (isAdding) {
                    keywordLists.add(str);
                } else {
                    keywordLists.remove(str);
                }

            }

            reloadKeywordView();

        }
    };

    private void initWork() {
        imageView = findViewById(R.id.cloudImageView);

        addBtn = findViewById(R.id.addBtn);
        getBtn = findViewById(R.id.getBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        keywordView = findViewById(R.id.keywordView);
        dialog = new Dialog_Brain(this, posiBtn);
        infoBtn = findViewById(R.id.infoBtn);
        sendBtn = findViewById(R.id.sendBtn);
//
//        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
//
//        fab1 = (FloatingActionButton) findViewById(R.id.actionFab1);
//        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
//        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
//
//        fab1.setOnClickListener(this);
//        fab2.setOnClickListener(this);
//        fab3.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.actionFab1:
//                anim();
//                Toast.makeText(this, "Floating Action Button", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.fab2:
//                anim();
//                Toast.makeText(this, "Button1", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.fab3:
//                anim();
//                Toast.makeText(this, "Button2", Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//
//    }

//    public void anim() {
//        if (isFabOpen) {
//            fab2.setImageResource(R.drawable.up_arrow_icon);
//            fab3.startAnimation(fab_close);
//            fab3.startAnimation(fab_close);
//            fab3.setClickable(false);
//            fab3.setClickable(false);
//            isFabOpen = false;
//        } else {
//            fab2.setImageResource(R.drawable.down_arrow_icon);
//
//            fab3.startAnimation(fab_open);
//            fab3.startAnimation(fab_open);
//            fab3.setClickable(true);
//            fab3.setClickable(true);
//            isFabOpen = true;
//        }
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
