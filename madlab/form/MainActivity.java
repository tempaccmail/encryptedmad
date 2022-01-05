package com.example.ex7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatePickerDialog datepickerdialog;
    RadioButton radiobutton;
    RadioGroup radiogroup;
    String state;
    Spinner statespinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        statespinner = (Spinner) findViewById(R.id.spinnerState);
        //ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource()
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statespinner.setAdapter(adapter);
        statespinner.setOnItemSelectedListener(this);

    }

    public void dateClick(View v){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        EditText dob = (EditText) findViewById(R.id.editTextDOB);

        datepickerdialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dob.setText(dayOfMonth+ "/" + (month+1) + "/" + year);
            }
        },year, month, day);
        datepickerdialog.show();

    }

    public void buttonClicked(View v){
        TextView textView1= (TextView) findViewById(R.id.opUserName);
        EditText editText = (EditText) findViewById(R.id.editTextUserName);
        String msg = editText.getText().toString();
        textView1.setText("Username : " + msg);

        TextView textView2= (TextView) findViewById(R.id.opPassword);
        EditText editText2 = (EditText) findViewById(R.id.editTextPassword);
        String msg2 = editText2.getText().toString();
        textView2.setText("Password : " + msg2);

        TextView textView3= (TextView) findViewById(R.id.opAddress);
        EditText editText3 = (EditText) findViewById(R.id.editTextAddress);
        String msg3 = editText3.getText().toString();
        textView3.setText("Address : " + msg3);

        TextView textView4= (TextView) findViewById(R.id.opGender);
        String msg4 = radiobutton.getText().toString();
        textView4.setText("Gender : " + msg4);

        TextView textView5 = (TextView) findViewById(R.id.opAge);
        EditText editText5 = (EditText) findViewById(R.id.editTextAge);
        String msg5 = editText5.getText().toString();
        textView5.setText("Age : " + msg5);

        TextView textView6 = (TextView) findViewById(R.id.opDOB);
        EditText editText6 = (EditText) findViewById(R.id.editTextDOB);
        String msg6 = editText6.getText().toString();
        textView6.setText("Date Of Birth : " + msg6);

        TextView textView7 = (TextView) findViewById(R.id.opState);
        textView7.setText("State: " +  state);

    }

    public void checkButton(View v){
        int radioID = radiogroup.getCheckedRadioButtonId();
        radiobutton = (RadioButton) findViewById(radioID);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        state = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}