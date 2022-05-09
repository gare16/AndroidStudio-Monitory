package com.apps.a10119911lat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
Developed by MochamadTegar
on Sunday, May 8 2022
*/

public class Biodata extends AppCompatActivity {

    public static final String ID_EXTRA_MSG = "test1";
    @BindView(R.id.inputName)
    EditText inputNama;
    @BindView(R.id.inputAge)
    EditText inputAge;
    @BindString(R.string.check_code_warning_empty_title_name)
    String emptyTitleName;
    @BindString(R.string.check_code_warning_empty_desc_name)
    String emptyMessageName;
    @BindString(R.string.check_code_warning_empty_title_age)
    String emptyTitleAge;
    @BindString(R.string.check_code_warning_empty_desc_age)
    String emptyMessageAge;
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;

    private String nameBiodata;
    private String ageBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnEnter)
    void selanjutnya() {

        nameBiodata = inputNama.getText().toString();
        ageBiodata = inputAge.getText().toString();

        if (isStringEmpty(nameBiodata)) {
            showWarningMessage();
        }else if(isStringEmpty(ageBiodata)) {
            showWarningMessage2();
        }else {
            Intent intent = new Intent(this, SayHi.class);
            //Melempar isi nama biodata ke kelas DoneActivity
            intent.putExtra(ID_EXTRA_MSG, nameBiodata);
            startActivity(intent);
        }

    }

    private void showWarningMessage2() {
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitleAge);
        textDesc.setText(emptyMessageAge);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitleName);
        textDesc.setText(emptyMessageName);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}