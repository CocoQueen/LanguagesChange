package com.coco.languageschange.model.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coco.languageschange.R;
import com.coco.languageschange.base.BaseActivity;
import com.coco.languageschange.utils.LocalManageUtils;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView;
    private Button mBtn1,mBtn2,mBtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textView = (TextView) findViewById(R.id.mTv);

        textView.setText(getString(R.string.user_select_language, LocalManageUtils.getSelectLanguage(this)));

        mBtn1=findViewById(R.id.mBtn1);
        mBtn2=findViewById(R.id.mBtn2);
        mBtn3=findViewById(R.id.mBtn3);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);

    }
    public static void enter(Context context){
        context.startActivity(new Intent(context,SettingActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtn1:
                selectLanguage(0);
                break;
            case R.id.mBtn2:
                selectLanguage(1);
                break;
            case R.id.mBtn3:
                selectLanguage(2);
                break;
        }

    }

    private void selectLanguage(int select) {
        LocalManageUtils.saveSelectLanguage(this,select);
        MainActivity.reStart(this);
    }
}
