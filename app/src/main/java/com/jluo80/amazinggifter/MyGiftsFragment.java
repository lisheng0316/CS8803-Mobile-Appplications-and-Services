package com.jluo80.amazinggifter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class MyGiftsFragment extends Fragment {

    private ArrayList<Gift> gifts;
    private RecyclerView mRecyclerView;

    public MyGiftsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gifts = new ArrayList<>();

        gifts = new ArrayList<>();
        gifts.add(new Gift("1", "zero to one", "25", "test", "test"));



        View rootView =  inflater.inflate(R.layout.fragment_list_view, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new MyGiftRecyclerAdapter(getContext(), gifts));

        return rootView;
    }
}