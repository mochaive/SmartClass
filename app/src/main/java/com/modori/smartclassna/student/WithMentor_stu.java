package com.modori.smartclassna.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.modori.smartclassna.R;
import com.modori.smartclassna.VideoCallActivity;

public class WithMentor_stu extends Fragment {

    EditText inputChannel;
    Button connectBtn;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.stu_withmentor, container, false);

        inputChannel = view.findViewById(R.id.inputChannel_stu);
        connectBtn = view.findViewById(R.id.connectBtn_stu);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String channelStr = inputChannel.getText().toString();
                if (!channelStr.equals("")) {
                    Intent goVideoCall = new Intent(view.getContext(), VideoCallActivity.class);
                    goVideoCall.putExtra(channelStr, "ChannelName");
                    startActivity(goVideoCall);
                }
            }
        });

        return view;

    }
}
