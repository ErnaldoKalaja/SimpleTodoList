package com.example.tutorialtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSaveEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSaveEdit = findViewById(R.id.btnSaveEdit);

        getSupportActionBar().setTitle("Edit item");

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When the user is done editing, they click the save button
        btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an intent which will contain the results
                Intent intent = new Intent();
                //pass the results of editing
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set the results of the intent
                setResult(RESULT_OK, intent);
                //finish the activity and fo back
                finish();
            }
        });
    }
}