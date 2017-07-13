package edu.application.yancychan.checkin.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.AbsenseStudentAdapter;
import edu.application.yancychan.checkin.adapters.StudentAdapter;
import edu.application.yancychan.checkin.beans.Student;


public class Tab2Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private AbsenseStudentAdapter adapter;
    private View mView;

    public Student[] students = {new Student(41455078,R.drawable.man,true),new Student(41455066,
            R.drawable.man,false),
            new Student(41455011,R.drawable.woman,true),new Student(41455073,R.drawable.man,true),
            new Student(41455228,R.drawable.woman,false),new Student(41455118,R.drawable.man,true),
            new Student(49455070,R.drawable.man,false),new Student(41155378,R.drawable.woman,false)};

    private List<Student> studentList = new ArrayList<>();
    private List<Student> absenseStudentList = new ArrayList<>();

    public void initStudents(){
        studentList.clear();
        for (int i=0; i<students.length; i++){
            studentList.add(students[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab2, container,false);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view2);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipe_refresh_tab2);
        GridLayoutManager layoutManager = new GridLayoutManager(mRecyclerView.getContext(),4);
        mRecyclerView.setLayoutManager(layoutManager);
        initStudents();
        setListeners();
        for (int i=0; i<studentList.size(); i++){
            if (!studentList.get(i).isPresent())
                absenseStudentList.add(studentList.get(i));
        }
        adapter = new AbsenseStudentAdapter(absenseStudentList);
        mRecyclerView.setAdapter(adapter);
    }

    private void setListeners(){
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshStudents();
            }
        });
    }

    private void refreshStudents() {
        // TODO: 17-7-12 下拉刷新功能
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        absenseStudentList.clear();
                        for (int i=0; i<studentList.size(); i++){
                            if (!studentList.get(i).isPresent())
                                absenseStudentList.add(studentList.get(i));
                        }
                        adapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}
