package com.amap.api.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.amap.loc.ar;
import com.amap.loc.b;
import com.amap.loc.c;
import com.amap.loc.cp;
import com.amap.loc.q;

public class APSService
        extends Service {
    APSServiceBase a;

    public IBinder onBind(Intent paramIntent) {
        try {
            String str1 = paramIntent.getStringExtra("apiKey");
            String str2 = paramIntent.getStringExtra("packageName");
            String str3 = paramIntent.getStringExtra("sha1AndPackage");
            String str4 = paramIntent.getStringExtra("as");
            Log.i("修改前数据", "apiKey:" + str1 + "\npackageName:" + str2 + "\nsha1AndPackage:" + str3 + "\nas:" + str4);
            paramIntent.putExtra("apiKey", "93036c13932aba6eeaee2a02656f14d7");
            paramIntent.putExtra("packageName", "com.lge.clock");
            paramIntent.putExtra("sha1AndPackage", "FA:AB:F5:02:B2:17:AC:D3:DA:46:38:ED:FF:E3:0C:A3:E4:67:0A:50:com.lge.clock");
            str1 = paramIntent.getStringExtra("apiKey");
            str2 = paramIntent.getStringExtra("packageName");
            str3 = paramIntent.getStringExtra("sha1AndPackage");
            str4 = paramIntent.getStringExtra("as");
            Log.i("修改后数据", "apiKey:" + str1 + "\npackageName:" + str2 + "\nsha1AndPackage:" + str3 + "\nas:" + str4);
            return this.a.onBind(paramIntent);
        } catch (Throwable localThrowable) {
            c.a(localThrowable, "APSService", "onBind");
        }
        return null;
    }

    public void onCreate(Context paramContext) {
        try {
            boolean bool = cp.d(paramContext);
            if (bool) {
                q localq = c.a("loc", "2.9.0");
                this.a = ((APSServiceBase) ar.a(paramContext, localq, "com.amap.api.location.APSServiceWrapper", b.class, new Class[]{Context.class}, new Object[]{paramContext}));
            } else if (this.a == null) {
                this.a = new b(this);
            }
        } catch (Throwable localThrowable1) {
        }
        try {
            if (this.a == null) {
                this.a = new b(this);
            }
            this.a.onCreate();
        } catch (Throwable localThrowable2) {
            c.a(localThrowable2, "APSService", "onCreate");
        }
        super.onCreate();
    }

    public void onCreate() {
        onCreate(this);
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        try {
            return this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
        } catch (Throwable localThrowable) {
            c.a(localThrowable, "APSService", "onStartCommand");
        }
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }

    public void onDestroy() {
        try {
            this.a.onDestroy();
        } catch (Throwable localThrowable) {
            c.a(localThrowable, "APSService", "onDestroy");
        }
        super.onDestroy();
    }
}
