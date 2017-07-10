package edu.application.yancychan.checkin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.activities.CourseDetailActivity;
import edu.application.yancychan.checkin.activities.CourseEditActivity;
import edu.application.yancychan.checkin.activities.CourseListActivity;
import edu.application.yancychan.checkin.beans.Course;
import edu.application.yancychan.checkin.utils.ItemSlideHelper;

/**
 * Created by yancychan on 17-4-6.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> implements ItemSlideHelper.Callback{

    private Context mContent;
    private List<Course> mCourseList = new ArrayList<Course>();

    private RecyclerView mRecyclerView;

    //自定义ViewHolder
    static class CourseViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.courseName_item)
        TextView courseName;
        @InjectView(R.id.course_item)
        LinearLayout courseItem;
        @InjectView(R.id.course_edit)
        TextView courseEdit;
        @InjectView(R.id.course_delete)
        TextView courseDelete;

        public CourseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }

    public CourseAdapter(Context context,List<Course> courseList){
        this.mContent = context;
        this.mCourseList = courseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContent == null){
            mContent = parent.getContext();
        }
        final View view = LayoutInflater.from(mContent).inflate(R.layout.course_item,
                parent,false);
        final CourseViewHolder holder = new CourseViewHolder(view);

        return holder;
    }

    /**
     * 将recyclerView绑定Slide事件
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
        mRecyclerView.addOnItemTouchListener(new ItemSlideHelper(mRecyclerView.getContext(), this));
    }

    @Override
    public void onBindViewHolder(final CourseViewHolder holder, final int position) {
        Course course = mCourseList.get(position);
        holder.courseName.setText(course.getCourseName());

        //消息主体监听, 点击进入课程详细信息界面
        holder.courseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent,"进入详细界面",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContent,CourseDetailActivity.class);
                mContent.startActivity(intent);
            }
        });

        //侧滑栏编辑界面监听, 进入编辑界面
        holder.courseEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 17-7-8 编辑页面未写
                Toast.makeText(mContent, "进入编辑界面", Toast.LENGTH_SHORT).show();
                notifyItemChanged(holder.getAdapterPosition());
                Intent intent = new Intent(mContent, CourseEditActivity.class);
                mContent.startActivity(intent);
            }
        });

        //侧滑栏删除时事件监听
        holder.courseDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent, "删除", Toast.LENGTH_SHORT).show();
                removeCourse(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    /**
     * 此方法用来计算水平方向移动的距离
     *
     * @param holder
     * @return
     */
    @Override
    public int getHorizontalRange(RecyclerView.ViewHolder holder) {
        if (holder.itemView instanceof LinearLayout) {
            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            //viewGroup包含3个控件，即消息主item、编辑、删除，返回为编辑宽度+删除宽度
            return viewGroup.getChildAt(1).getLayoutParams().width
                    + viewGroup.getChildAt(2).getLayoutParams().width;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder getChildViewHolder(View childView) {
        return mRecyclerView.getChildViewHolder(childView);
    }

    @Override
    public View findTargetView(float x, float y) {
        return mRecyclerView.findChildViewUnder(x, y);
    }

    //删除一个课程
    public void removeCourse(int position) {
        mCourseList.remove(position);
        notifyItemRemoved(position);
    }
}
