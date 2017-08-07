package com.example.user.sayin.view.holder.pods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.user.sayin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ywn
 */

public class EmptyViewPod extends RelativeLayout {

    @BindView(R.id.lbl_empty)
    TextView lblEmpty;

    @BindView(R.id.iv_empty)
    ImageView ivEmpty;

    @BindView(R.id.btn_action_for_empty)
    Button btnActionForEmpty;

    public EmptyViewPod(Context context) {
        super(context);
    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setEmptyLabel(String emptyLabel) {
        lblEmpty.setText(emptyLabel);
    }

    public void setEmptyLabel(String emptyLabel, int textColor) {
        lblEmpty.setText(emptyLabel);
        lblEmpty.setTextColor(textColor);
    }

    public void setEmptyAction(String emptyAction, final EmptyActionDelegate delegate) {
        btnActionForEmpty.setVisibility(View.VISIBLE);
        btnActionForEmpty.setText(emptyAction);
        btnActionForEmpty.setOnClickListener(delegate);
    }

    public void setEmptyImage(int resourceId) {
        ivEmpty.setImageResource(resourceId);
    }

    public interface EmptyActionDelegate extends OnClickListener {

    }
}
