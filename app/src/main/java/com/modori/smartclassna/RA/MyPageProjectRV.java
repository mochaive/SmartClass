package com.modori.smartclassna.RA;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.modori.smartclassna.R;
import com.modori.smartclassna.model.Info;
import com.modori.smartclassna.model.ProjectModel;

import java.util.List;

public class MyPageProjectRV extends RecyclerView.Adapter<MyPageProjectRV.ViewHolder> {

    private List<Info> projectLists;
    private Context context;

    public MyPageProjectRV(Context context, List<Info> lists) {
        this.context = context;
        this.projectLists = lists;
    }

    @NonNull
    @Override
    public MyPageProjectRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPageProjectRV.ViewHolder holder, int position) {
        Info item = projectLists.get(position);

        holder.boardTitle.setText(item.getBoardTitle());
        holder.users.setText(item.getUsers());
        holder.subject.setText(item.getSubject());

        if (item.getType().equals("V")) {
            holder.type.setText("비주얼 씽킹");

        } else {
            holder.type.setText("브레인 스토밍");

        }
        holder.createAt.setText(item.getCreateAt());
        holder.updateAt.setText(item.getUpdateAt());


    }

    @Override
    public int getItemCount() {
        return projectLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView boardTitle, users, subject, type, createAt, updateAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            boardTitle = itemView.findViewById(R.id.boardTitle);
            users = itemView.findViewById(R.id.users);
            subject = itemView.findViewById(R.id.subject);
            type = itemView.findViewById(R.id.type);
            createAt = itemView.findViewById(R.id.createAt);
            updateAt = itemView.findViewById(R.id.updateAt);
        }
    }
}
