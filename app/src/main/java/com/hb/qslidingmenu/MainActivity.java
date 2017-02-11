package com.hb.qslidingmenu;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView mainListView;
    private ListView menuListView;
    private ImageView icon;
    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById(R.id.main_listview);
        menuListView = (ListView) findViewById(R.id.menu_listview);
        icon = (ImageView) findViewById(R.id.iv_head);
        slidingMenu = (SlidingMenu) findViewById(R.id.slidingmenu);

        mainListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Constant.mains));

        menuListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Constant.menus){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                return textView;
            }
        });
//        一个回调接口  用来控制这个imageview   icon的动画
        slidingMenu.setOnSlidingMenuListener(new SlidingMenu.onSlidingMenuListener() {
            @Override
            public void rotate(float fraction) {
                icon.setRotation(360*fraction);
            }

            @Override
            public void isOpen(boolean isopen) {
                if (isopen){
                    Toast.makeText(MainActivity.this,"芝麻开门",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"西瓜关门",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
