package com.apps.a10119911lat3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
Developed by MochamadTegar
on Sunday, May 8 2022
*/


public class SayHi extends AppCompatActivity {

    @BindView(R.id.textSayHi)
    TextView txtNama;
    @BindString(R.string.activation_beres)
    String beres;
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @BindString(R.string.activation_setiap)
    String setiap;
    @BindString(R.string.activation_buat)
    String buat;

    public static final String ID_EXTRA_MSG_EXIT = "com.apps.rizkiadam.latihan1.MSG_EXIT";

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hi);
        ButterKnife.bind(this);
        bindExtra();
    }

    private void bindExtra() {
        //Menampung value yang dilempar dari BiodataActivity
        Intent intent = getIntent();
        name = intent.getStringExtra(Biodata.ID_EXTRA_MSG);
        // Mengeset nama sesuai dengan data nama yang dilempar menjadi satu kesatuan kalimat
        txtNama.setText(beres+" "+name+" "+sudahBisa+" "+name+" "+setiap+" "+name+" "+buat);
    }
    @OnClick(R.id.btnClose)
    public void selesai(View view) {
        System.exit(0);
    }
}

