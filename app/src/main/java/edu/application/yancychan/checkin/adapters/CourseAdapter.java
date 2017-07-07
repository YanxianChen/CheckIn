package edu.application.yancychan.checkin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.activities.CourseDetailActivity;
import edu.application.yancychan.checkin.activities.CourseListActivity;
import edu.application.yancychan.checkin.beans.Course;

/**
 * Created by yancychan on 17-4-6.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context mContent;

    private List<Course> mCourseList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView courseName;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            courseName = (TextView) view.findViewById(R.id.courseName);
        }
    }

    public CourseAdapter(List<Course> courseList){
        mCourseList = courseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContent == null){
            mContent = parent.getContext();
        }
        final View view = LayoutInflater.from(mContent).inflate(R.layout.course_item,
                parent,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                final Course course = mCourseList.get(position);
                Intent intent = new Intent(mContent,CourseDetailActivity.class);
                intent.putExtra(CourseListActivity.COURSE_NAME,"课程名: "+course.getCourseName());
                intent.putExtra(CourseListActivity.COURSE_ID,"课程ID: "+new StringBuilder().append(course.getCourseId()));
                intent.putExtra(CourseListActivity.NUMBER_OF_STUDENT,"学生人数: "+course.getNumberOfStudent());
                mContent.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = mCourseList.get(position);
        holder.courseName.setText(course.getCourseName());
    }


    @Override
    public int getItemCount() {
        return mCourseList.size();
    }
}
