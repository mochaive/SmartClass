package com.modori.smartclassna.student;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.modori.smartclassna.Api.ApiClient;
import com.modori.smartclassna.R;
import com.modori.smartclassna.RA.BulletGridAdapter;
import com.modori.smartclassna.RA.MyPageProjectRV;
import com.modori.smartclassna.model.BulletGridView;
import com.modori.smartclassna.model.Info;
import com.modori.smartclassna.model.ProjectModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Board_stu extends Fragment {

    BulletGridAdapter adapter;
    GridView gridView;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.stu_board, container, false);

        gridView = view.findViewById(R.id.gridview_bullet);
        getProjectLists("ryusm150@naver.com");

        return view;

    }

    private void getProjectLists(String userEmail) {
        String userEmail2 = "test@gmail.com";
        ApiClient.getMyProjectLists().getMyProjectLists(userEmail).enqueue(new Callback<ProjectModel>() {

            @Override
            public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                if (response.isSuccessful()) {
                    int index = response.body().getInfo().size();
                    System.out.println("test : "+index);
                    Log.d("MyPage_stu.java","통신 성공");

                    List<Info> infos = response.body().getInfo();
                    //adapter = new BulletGridAdapter(this, infos);




                }

                //Toast.makeText(getContext(), "문제가 발생했습니다.", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ProjectModel> call, Throwable t) {
                Toast.makeText(view.getContext() , "문제가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
