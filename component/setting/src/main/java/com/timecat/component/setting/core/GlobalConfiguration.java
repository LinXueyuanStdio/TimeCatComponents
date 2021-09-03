package com.timecat.component.setting.core;

import android.app.Application;
import android.content.Context;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.tencent.mmkv.MMKV;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

/**
 * ================================================ CommonSDK 的 GlobalConfiguration
 * 含有有每个组件都可公用的配置信息, 每个组件的 AndroidManifest 都应该声明此 ConfigModule
 *
 * @see <a href="https://github.com/JessYanCoding/ArmsComponent/wiki#3.3">ConfigModule wiki 官方文档</a>
 * Created by JessYan on 30/03/2018 17:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class GlobalConfiguration implements ConfigModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlobalConfigModule.Builder builder) {
    }

    @Override
    public void injectAppLifecycle(@NonNull Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(0, new AppLifecycles() {

            @Override
            public void attachBaseContext(@NonNull Context base) {
            }

            @Override
            public void onCreate(@NonNull Application application) {
                MMKV.initialize(application);
            }

            @Override
            public void onTerminate(@NonNull Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(@NonNull Context context,
            @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles) {
    }

    @Override
    public void injectFragmentLifecycle(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }


}
