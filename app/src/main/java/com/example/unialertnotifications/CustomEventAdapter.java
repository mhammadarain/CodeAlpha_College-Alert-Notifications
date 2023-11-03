package com.example.unialertnotifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomEventAdapter extends ArrayAdapter<CustomEvent> {
    public CustomEventAdapter(Context context, CustomEvent[] events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate a custom layout for your list item, and populate it with the event details.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_event_list_item, parent, false);
        }

        CustomEvent event = getItem(position);

        TextView eventNameTextView = convertView.findViewById(R.id.eventNameTextView);
        TextView eventDateTextView = convertView.findViewById(R.id.eventDateTextView);

        eventNameTextView.setText(event.getEventName());
        eventDateTextView.setText(event.getEventDate().toString());

        return convertView;
    }
}

