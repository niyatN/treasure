package com.example.shreyansh.treasure;

/**
 * Created by Shreyansh on 12/18/2017.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback{

    Button but;
    TextView score, pos;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ButtonStyleChange();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void ButtonStyleChange()
    {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "pirate.ttf");


        score = (TextView) findViewById(R.id.score);
        score.setTypeface(tf);
        score = (TextView) findViewById(R.id.position);
        score.setTypeface(tf);
        score = (TextView) findViewById(R.id.pos);
        score.setTypeface(tf);


        but = (Button) findViewById(R.id.but1);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but2);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but3);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but4);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but5);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but6);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but7);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but8);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but9);
        but.setTypeface(tf);
        but = (Button) findViewById(R.id.but10);
        but.setTypeface(tf);
    }


    public void openRiddle(View view)
    {
        CustomDialogClass cdd=new CustomDialogClass(this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.getWindow().setLayout(1920, 1080);

        /*Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.custom_dialog);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();*/

    }



    public class CustomDialogClass extends Dialog implements android.view.View.OnClickListener {


        public Activity c;
        public Dialog d;
        public Button yes;
        TextView tv, content;

        public CustomDialogClass(Activity a) {
            super(a);
            this.c = a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.custom_dialog);

            tv = (TextView) findViewById(R.id.head);
            content = (TextView) findViewById(R.id.content);
            Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "pirate.ttf");
            tv.setTypeface(tf);

            content.setMovementMethod(new ScrollingMovementMethod());
            //yes = (Button) findViewById(R.id.btn_yes);
            // yes.setOnClickListener(this);

            //tv = (TextView) findViewById(R.id.head);
            //Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "pirate.ttf");
            //but.setTypeface(tf);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                /*case R.id.btn_yes:
                    dismiss();
                    break;*/
                default:
                    dismiss();
                    break;
            }
            dismiss();
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setTitle("Really!?")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                            //Toast.makeText(getApplicationContext(), "BACK", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(Intent.ACTION_MAIN);
                            a.addCategory(Intent.CATEGORY_HOME);
                            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(a);
                            //return true;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                            //Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
