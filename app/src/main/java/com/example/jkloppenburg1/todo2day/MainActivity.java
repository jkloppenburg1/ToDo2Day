package com.example.jkloppenburg1.todo2day;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let's make a DBHelper reference:
        DBHelper db = new DBHelper(this);

        // FOR NOW (TEMPORARY), delete the old database, then create a new one
        this.deleteDatabase(DBHelper.DATABASE_TABLE);

        // Let's make a new task and add to database:
        db.addTask(new Task(1, "Study for CS273", 0));
        db.addTask(new Task(2, "Eat Tacos", 0));
        db.addTask(new Task(3, "Solve World Hunger", 0));
        db.addTask(new Task(4, "Set to Wumbo", 0));
        db.addTask(new Task(5, "Use the Force", 0));

        // Let's get all the tasks from the databse and print them with Log.i()
        ArrayList<Task> allTasks = db.getAllTasks();
        // Loop through each task, print to Log.i
        for (Task singleTask : allTasks)
            Log.i("DATABASE TASK", singleTask.toString());
    }
}
