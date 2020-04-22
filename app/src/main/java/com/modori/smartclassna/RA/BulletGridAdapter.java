package com.modori.smartclassna.RA;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.modori.smartclassna.model.BulletGridView;
import com.modori.smartclassna.model.Info;
import com.modori.smartclassna.model.ProjectModel;

import java.util.ArrayList;
import java.util.List;

public class BulletGridAdapter extends BaseAdapter {

    private Context context;
    private List<Info> bulletLists = new ArrayList<>();

    public BulletGridAdapter(Context context, List<Info> bulletLists) {
        this.context = context;
        this.bulletLists = bulletLists;
    }

    @Override
    public int getCount() {
        return bulletLists.size();
    }

    @Override
    public Object getItem(int i) {
        return bulletLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new BulletGridView(context);
        }
        ((BulletGridView) view).setDate(bulletLists.get(i));

        return view;

    }

}

