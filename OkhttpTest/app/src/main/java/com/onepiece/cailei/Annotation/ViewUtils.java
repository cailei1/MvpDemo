package com.onepiece.cailei.Annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class ViewUtils {


    public static void inject(Activity activity) throws IllegalAccessException {

        Class<?> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ViewById viewById = field.getAnnotation(ViewById.class);
            if (viewById != null) {
                //获取注解里面的Id值
                int viewId = viewById.value();

                View view = activity.findViewById(viewId);
                if (view != null) {
                    //能够注入所有修饰符
                    field.setAccessible(true);
                    field.set(activity, view);
                }

            }
        }
    }
}
