package com.example.simpleproject;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan Action Bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

//        try {
//            PackageInfo info = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                String hashKey = new String(Base64.encode(md.digest(), 0));
//                Log.i("KEY", "printHashKey() Hash Key: " + hashKey);

//        } catch (NoSuchAlgorithmException e) {
//            Log.e("KEY", "printHashKey()", e);
//        } catch (Exception e) {
//            Log.e("KEY", "printHashKey()", e);
//        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 3000L); //3000 l = 3 detik
    }
}
