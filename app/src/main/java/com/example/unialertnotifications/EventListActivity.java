package com.example.unialertnotifications;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class EventListActivity extends AppCompatActivity {

    private ListView eventListView;

    private CustomEvent[] events; // Change the data type to your custom Event class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventListView = findViewById(R.id.eventListView);

        // Get the list of events from the intent
        events = (CustomEvent[]) getIntent().getSerializableExtra("events");

        // Create an ArrayAdapter to populate the ListView
        CustomEventAdapter adapter = new CustomEventAdapter(this, events);
        eventListView.setAdapter(adapter);

    }
}
