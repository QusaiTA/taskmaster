package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTask.class);
                startActivity(intent);
            }
        });


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllTask.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.settings).setOnClickListener(view -> {
            Intent settingIntent = new Intent(MainActivity.this,Settings.class);
            startActivity(settingIntent);
        });
//        findViewById(R.id.eat).setOnClickListener(view -> {
//            Intent taskDetailsPageEat = new Intent(MainActivity.this,TaskDetails.class);
//            taskDetailsPageEat.putExtra("Task","Eating");
//            startActivity(taskDetailsPageEat);
//        });
//        findViewById(R.id.Code).setOnClickListener(view -> {
//            Intent taskDetailsPageCode = new Intent(MainActivity.this,TaskDetails.class);
//            taskDetailsPageCode.putExtra("Task","Coding");
//            startActivity(taskDetailsPageCode);
//        });
//        findViewById(R.id.Sleep).setOnClickListener(view -> {
//            Intent taskDetailsPageSleep = new Intent(MainActivity.this,TaskDetails.class);
//            taskDetailsPageSleep.putExtra("Task","Sleeping");
//            startActivity(taskDetailsPageSleep);
//        });

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Coding","im coding write now, stay away!","new"));
        tasks.add(new Task("Eating","Eating Now","in progress"));
        tasks.add(new Task("Sleeping","i will go to sleep","complete"));
        tasks.add(new Task("Coding","im coding write now, stay away!","new"));
        tasks.add(new Task("Eating","Eating Now","new"));
        tasks.add(new Task("Sleeping","i will go to sleep","assigned"));
        tasks.add(new Task("Coding","im coding write now, stay away!","in progress"));
        tasks.add(new Task("Eating","Eating Now","complete"));
        tasks.add(new Task("Sleeping","i will go to sleep","new"));


        RecyclerView AllTasks = findViewById(R.id.taskRecycler);

        AllTasks.setLayoutManager(new LinearLayoutManager(this));

        AllTasks.setAdapter(new TaskAdapter(tasks,this));


    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String instName = sharedPreferences.getString("username","Go and set the Instructor Name");

        TextView welcome = findViewById(R.id.welcomeMsg);
        welcome.setText( instName +" : Task");
    }
}
