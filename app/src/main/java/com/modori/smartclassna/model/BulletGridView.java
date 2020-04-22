package com.modori.smartclassna.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.modori.smartclassna.R;

import org.w3c.dom.Text;

public class BulletGridView extends LinearLayout {

    TextView type_b, date_b, name_b, name2_b, school_b;


    public BulletGridView(Context context) {
        super(context);
        init(context);

    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.stu_board_item,this);
        type_b = view.findViewById(R.id.type_b);
        date_b = view.findViewById(R.id.date_b);
        name_b = view.findViewById(R.id.name_b);
        name2_b = view.findViewById(R.id.name2_b);
        school_b = view.findViewById(R.id.school_b);
    }

    public void setDate(Info model){
        type_b.setText(model.getType());
        date_b.setText(model.getUpdateAt());
        name_b.setText(model.getBoardTitle());
        name2_b.setText("2");
        school_b.setText(model.getSchool());
    }
}
