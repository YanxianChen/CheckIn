package edu.application.yancychan.checkin.activities.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.StudentAdapter;
import edu.application.yancychan.checkin.beans.Student;

public class Tab1Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mView;

    public Student[] students = {new Student(41455078,R.drawable.man,true),new Student(41455066,
            R.drawable.man,false),
            new Student(41455011,R.drawable.woman,true),new Student(41455073,R.drawable.man,true),
            new Student(41455228,R.drawable.woman,false),new Student(41455118,R.drawable.man,true),
            new Student(49455070,R.drawable.man,false),new Student(41155378,R.drawable.woman,false)};

    private List<Student> studentList = new ArrayList<>();

    public void initStudents(){
        studentList.clear();
        for (int i=0; i<students.length; i++){
            studentList.add(students[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab1, container,false);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view1);
        GridLayoutManager layoutManager = new GridLayoutManager(mRecyclerView.getContext(),4);
        mRecyclerView.setLayoutManager(layoutManager);
        initStudents();
        StudentAdapter adapter = new StudentAdapter(studentList);
        mRecyclerView.setAdapter(adapter);
    }

}
