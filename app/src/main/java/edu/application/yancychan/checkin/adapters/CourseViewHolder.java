package edu.application.yancychan.checkin.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import edu.application.yancychan.checkin.R;

/**
 * Created by yancychan on 17-7-8.
 */

class CourseViewHolder extends RecyclerView.ViewHolder {

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
