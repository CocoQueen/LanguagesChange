package com.coco.languageschange.model.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coco.languageschange.R;
import com.coco.languageschange.model.service.MyService;
import com.coco.languageschange.utils.LocalManageUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvSystemLanguage;
    private TextView tvUserSelectLanguage;
    private TextView tvValue;
    private TextView tvValue2;
    private Button mBtn1/*,mBtn2*/,mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setValue();

    }

    private void setValue() {
        tvSystemLanguage.setText(getString(R.string.system_language, LocalManageUtils.getSystemLocal(this).getDisplayLanguage()));
        tvUserSelectLanguage.setText(getString(R.string.user_select_language,LocalManageUtils.getSelectLanguage(this)));
        tvValue.setText(getString(R.string.tv3_value));
        tvValue2.setText(getApplicationContext().getString(R.string.tv3_value));
    }

    private void initView() {
        mBtn1 = findViewById(R.id.mBtn1);
//        mBtn2 = findViewById(R.id.mBtn2);
        mBtn3 = findViewById(R.id.mBtn3);

        tvSystemLanguage = findViewById(R.id.tv_system_language);
        tvUserSelectLanguage = findViewById(R.id.tv_user_select);
        tvValue = findViewById(R.id.tv_3);
        tvValue2 = findViewById(R.id.tv_4);

        mBtn1.setOnClickListener(this);
//        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtn1:
                SecondActivity.enter(this);
                break;
//            case R.id.mBtn2:
//                startService(new Intent(this, MyService.class));
//                break;
            case R.id.mBtn3:
                SettingActivity.enter(this);
                break;
        }

    }

    public static void reStart(Context context) {
        context.startActivity(new Intent(context,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
