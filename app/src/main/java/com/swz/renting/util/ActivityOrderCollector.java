package com.swz.renting.util;

/**
 * Created by wnw on 2017/5/5.
 */

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是用户下单流程的Activity管理器
 * */
public class ActivityOrderCollector {

    public static List<Activity> activities = new ArrayList<Activity>();

    /**添加一个Activity到Activities中*/
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**从activities中删除一个Activity*/
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**将这个activities中的所有Activity全部删除，这用户完成注册后调用这个方法*/
    public static void finishAllActivity(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
