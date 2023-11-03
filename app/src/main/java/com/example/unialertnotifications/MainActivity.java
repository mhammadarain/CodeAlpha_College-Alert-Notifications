package com.example.unialertnotifications;
// ...

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText eventNameEditText;
    private DatePicker eventDatePicker;
    private Button btn_setEvent;
    private Button btn_eventList;

    private CustomEvent[] events = new CustomEvent[0]; // Use the concrete class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventNameEditText = findViewById(R.id.eventNameEditText);
        eventDatePicker = findViewById(R.id.eventDatePicker);
        btn_setEvent = findViewById(R.id.btn_setEvent);
        btn_eventList = findViewById(R.id.btn_eventList);

        btn_setEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the event name and date from the EditText
                String eventName = eventNameEditText.getText().toString();

                int year = eventDatePicker.getYear();
                int month = eventDatePicker.getMonth();
                int dayOfMonth = eventDatePicker.getDayOfMonth();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                Date eventDate = calendar.getTime();

                // Save the event using the concrete CustomEvent class
                events = Arrays.copyOf(events, events.length + 1);
                events[events.length - 1] = new CustomEvent(eventName, eventDate);

                // Clear the EditText
                eventNameEditText.setText("");

                // Show a toast message to the user
                Toast.makeText(MainActivity.this, "Event saved successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_eventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the EventListActivity
                Intent intent = new Intent(MainActivity.this, EventListActivity.class);
                intent.putExtra("events", events);
                startActivity(intent);
            }
        });

    }
}
