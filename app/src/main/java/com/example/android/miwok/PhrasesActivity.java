package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordAdapter adapter = new wordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}