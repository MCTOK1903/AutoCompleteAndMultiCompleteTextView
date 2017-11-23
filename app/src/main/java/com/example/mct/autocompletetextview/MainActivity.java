package com.example.mct.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textFullname;
    private AutoCompleteTextView textCity;
    private MultiAutoCompleteTextView textProgramingLanguage;

    private Button buttonSubmit;

    private String[] city = {"Mersin","Tokat","Urfa","Van","Ankara","Antalya"};
    private String[] languages = {"Java ","CSharp","Visual Basic","Swift","C/C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        textFullname = findViewById( R.id.editText );
        textCity = findViewById( R.id.autoCompleteTextView );
        textProgramingLanguage = findViewById( R.id.multiAutoCompleteTextView );
        buttonSubmit = findViewById( R.id.button );

        ArrayAdapter adapterCity = new ArrayAdapter( this,android.R.layout.simple_list_item_1,city );
        textCity.setAdapter( adapterCity );

        // set the minimum number of characters, to show suggestions
        textCity.setThreshold( 1 );

        ArrayAdapter adapterLanguages = new ArrayAdapter( this,android.R.layout.simple_list_item_1,languages );
        textProgramingLanguage.setAdapter( adapterLanguages );
        textProgramingLanguage.setThreshold( 1 );

        textProgramingLanguage.setTokenizer( new MultiAutoCompleteTextView.CommaTokenizer() );

        buttonSubmit.setOnClickListener( new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFrom();
            }
        } );
    }

    private void submitFrom() {
        String text = "FullName: " + this.textFullname.getText().toString()
                + "\nCountry: " + this.textCity.getText().toString()
                +"\nLanguages : " + this.textProgramingLanguage.getText().toString();

        Toast.makeText( this,text,Toast.LENGTH_LONG ).show();
    }
}
