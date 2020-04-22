package com.modori.smartclassna;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog_Brain extends Dialog {

    private EditText inputKeyword;
    private Button negaBtn;
    private Button posiBtn;

    private View.OnClickListener mPosiListener;
    private Context context;

    public Dialog_Brain(Context context, View.OnClickListener mPosiListener) {
        super(context);
        this.mPosiListener = mPosiListener;
    }

    String inputKeywordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = getContext().getResources().getDisplayMetrics(); //디바이스 화면크기를 구하기위해
        int width = dm.widthPixels; //디바이스 화면 너비
        int height = dm.heightPixels; //디바이스 화면 높이



        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.width = width / 2;
        layoutParams.height = height / 2;
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.dialog_brainstorm);

        //셋팅
        posiBtn = (Button) findViewById(R.id.submitBtn);
        negaBtn = findViewById(R.id.cancelBtn);

        negaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        inputKeyword = findViewById(R.id.inputKeyword);
        inputKeyword.setText("");

        //클릭 리스너 셋팅 (클릭버튼이 동작하도록 만들어줌.)
        posiBtn.setOnClickListener(mPosiListener);



    }

    public String getKeyword() {

        if (!inputKeyword.getText().toString().isEmpty()) {
            dismiss();
            return inputKeyword.getText().toString();
        }
        Toast.makeText(context, "공백은 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
        dismiss();
        return "";


    }
}
