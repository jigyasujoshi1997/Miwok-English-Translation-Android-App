package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        // Create an array of words

        final ArrayList<word> numbers = new ArrayList<word>();
        numbers.add(new word("one", "lutti",R.drawable.number_one, R.raw.number_one));
        numbers.add(new word("two", "otiiko",R.drawable.number_two, R.raw.number_two));
        numbers.add(new word("three", "tolookosu",R.drawable.number_three, R.raw.number_three));
        numbers.add(new word("four", "oyyisa",R.drawable.number_four, R.raw.number_four));
        numbers.add(new word("five", "massokka",R.drawable.number_five, R.raw.number_five));
        numbers.add(new word("six", "temmokka",R.drawable.number_six, R.raw.number_six));
        numbers.add(new word("seven", "kenekaku",R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new word("eight", "kawinta",R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new word("nine", "wo’e",R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new word("ten", "na’aacha",R.drawable.number_ten, R.raw.number_ten));

// Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordAdapter adapter = new wordAdapter(this, numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
                word words = numbers.get(position);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this,words.getmResourceId() );
                mediaPlayer.start();
            }
        });
    }
}