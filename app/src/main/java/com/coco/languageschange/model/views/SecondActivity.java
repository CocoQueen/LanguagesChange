package com.coco.languageschange.model.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.coco.languageschange.R;
import com.coco.languageschange.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.mTV);
        textView.setText(getString(R.string.tv3_value));
    }
    public static void enter(Context context){
        context.startActivity(new Intent(context,SecondActivity.class));
    }
}
