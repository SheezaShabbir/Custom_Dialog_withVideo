package com.example.naveed.customdialog;

import android.app.Dialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DialerKeyListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
   String uripath;
   Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog videodialog=new Dialog(MainActivity.this);
        videodialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        videodialog.setContentView(R.layout.activity_dialog);
        final VideoView videoscreenview = (VideoView) videodialog.findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.about);
        final MediaController controller=new MediaController(MainActivity.this);
        WindowManager.LayoutParams lp =videodialog.getWindow().getAttributes();
        videodialog.getWindow().setAttributes(lp);
        videodialog.show();
        videoscreenview.setVideoURI(uri);
        controller.setMediaPlayer(videoscreenview);
        videoscreenview.setMediaController(controller);
        videoscreenview.requestFocus();
        try {
            b1=(Button)videodialog.findViewById(R.id.start);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videoscreenview.start();
                }
            });
            b2=(Button)videodialog.findViewById(R.id.cancel);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videodialog.cancel();
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }

         }
}
