package com.swz.renting.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.swz.renting.R;
import com.swz.renting.bean.User;
import com.swz.renting.util.ActivityCollector;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wnw on 2017/5/5.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener{

    private CircleImageView userImg;  //头像
    private TextView nickNameView;    //昵称
    private TextView phoneView;       //电话号码
    private ImageView editNickName;   //编辑昵称

    private TextView infoTv;          //主页房租信息
    private TextView newsTv;          //主页新闻信息

    private User user;                     // 登录的用户
    private String url = null;             //用户的头像url地址
    private String imgName = null;         //用户的头像name名字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);
        getUser();  //获取用户数据
        initView(); //初始化界面
    }

    //获取本地保存的登录用户信息
    private void getUser() {
        user = new User();
        SharedPreferences preferences = getSharedPreferences("account", MODE_PRIVATE);
        user.setObjectId(preferences.getString("id", ""));
        user.setPhone(preferences.getString("phone", ""));
        user.setNickName(preferences.getString("nickname", ""));
        user.setPassword(preferences.getString("password", ""));
        url = preferences.getString("url", "");
        imgName = preferences.getString("imgName", "");
    }

    //初始化界面
    private void initView(){

        //菜单
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //侧边栏
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        userImg = (CircleImageView) navigationView.getHeaderView(0).findViewById(R.id.icon_user);
        nickNameView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.username);
        phoneView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.phone);
        editNickName = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.edit_nickname);

        infoTv = (TextView)findViewById(R.id.main_tv_renting_info);
        newsTv = (TextView)findViewById(R.id.main_tv_renting_news);


        //设置NavigationView里面的参数：昵称，电话，头像
        phoneView.setText(user.getPhone());
        nickNameView.setText(user.getNickName());
        Glide.with(this).load(url).into(userImg);

        //设置点击事件
        userImg.setOnClickListener(this);
        infoTv.setOnClickListener(this);
        newsTv.setOnClickListener(this);
        editNickName.setOnClickListener(this);
    }
    // 初始化，加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //菜单选中监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }


    //按键监听
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_tv_renting_info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.main_tv_renting_news:
                Intent intent1 = new Intent(this, NewsActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.icon_user:
                //用户头像点击
                Intent intent2 = new Intent(this, ImgUploadActivity.class);
                startActivityForResult(intent2, 2);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.edit_nickname:
                //用户昵称点击
                Intent intent3 = new Intent(this, EditNickNameActivity.class);
                intent3.putExtra("id", user.getObjectId());
                intent3.putExtra("nickname", user.getNickName());
                startActivityForResult(intent3, 4);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
