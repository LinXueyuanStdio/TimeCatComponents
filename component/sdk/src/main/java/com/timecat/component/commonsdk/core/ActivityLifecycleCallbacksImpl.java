/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.timecat.component.commonsdk.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

/**
 * ================================================ Created by JessYan on 02/04/2018 15:15
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(@NotNull Activity activity, Bundle savedInstanceState) {
        Timber.d("%s - onActivityCreated", activity);
    }

    @Override
    public void onActivityStarted(@NotNull Activity activity) {
        Timber.d("%s - onActivityStarted", activity);
    }

    @Override
    public void onActivityResumed(@NotNull Activity activity) {
        Timber.d("%s - onActivityResumed", activity);
    }

    @Override
    public void onActivityPaused(@NotNull Activity activity) {
        Timber.d("%s - onActivityPaused", activity);
    }

    @Override
    public void onActivityStopped(@NotNull Activity activity) {
        Timber.d("%s - onActivityStopped", activity);
    }

    @Override
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Timber.d("%s - onActivitySaveInstanceState", activity);
    }

    @Override
    public void onActivityDestroyed(@NotNull Activity activity) {
        Timber.d("%s - onActivityDestroyed", activity);
        //横竖屏切换或配置改变时, Activity 会被重新创建实例, 但 Bundle 中的基础数据会被保存下来,移除该数据是为了保证重新创建的实例可以正常工作
        if (activity.getIntent() != null) {
            activity.getIntent().removeExtra("isInitToolbar");
        }
    }
}
