package com.swz.renting.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.swz.renting.R;


/**
 * Created by wnw on 2017/4/6.
 */

public class MapActivity extends Activity{

  /*  //AMap是地图对象
    private AMap aMap;
    private MapView mapView;

    private Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getStore();
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);    // 此方法必须重写
        setMark();
    }

    //得到从上一个Activity中传递过来的经纬度
    private void getStore(){
        Intent intent = getIntent();
        store = (Store)intent.getSerializableExtra("store");
    }

    //在地图上标出店铺的位置
    private void setMark(){
        aMap = mapView.getMap();
        //设置缩放级别
        aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
        //将地图移动到具体的经纬度点
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(store.getLatitude(), store.getLongitude())));

        //画一个点
        LatLng latLng = new LatLng(store.getLatitude(),store.getLongitude());
        final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title(store.getName())
                .snippet(store.getAddress()));
        marker.showInfoWindow();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
*/
}