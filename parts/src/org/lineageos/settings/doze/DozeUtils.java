/*
 * Copyright (C) 2015 The CyanogenMod Project
 *               2017-2019 The LineageOS Project
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

package org.lineageos.settings.doze;

import android.content.Context;
import android.os.UserHandle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;

public final class DozeUtils {
    private static final String TAG = "DozeUtils";
    protected static final String SCREEN_OFF_UDFPS_ENABLED = "screen_off_udfps_enabled";

    public static void onBootCompleted(Context context) {
        enableScreenOffUdfpsByDefault(context);
    }

    private static void enableScreenOffUdfpsByDefault(Context context) {
        try {
            Settings.Secure.getIntForUser(
                    context.getContentResolver(),
                    SCREEN_OFF_UDFPS_ENABLED,
                    UserHandle.USER_CURRENT);
        } catch (SettingNotFoundException e) {
            Log.i(TAG, "Setting screen_off_udfps_enabled to 1 by default.");
            Settings.Secure.putIntForUser(
                    context.getContentResolver(),
                    SCREEN_OFF_UDFPS_ENABLED,
                    1,
                    UserHandle.USER_CURRENT);
        }
    }
}
