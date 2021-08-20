package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class PhrasesFragment extends Fragment {

    MediaPlayer mmediaPlayer;
    AudioManager mAudioManager;

    private Handler handler = new Handler();
    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mmediaPlayer.pause();
                        mmediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mmediaPlayer.start();
                    }
                }
            };


    public PhrasesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list, container, false);


        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        ArrayList<Wordphrases> words = new ArrayList<Wordphrases>();
        words.add(new Wordphrases("Where are you going?", "minto wuksus"));
        words.add(new Wordphrases("What is your name?", "tinnә oyaase'nә"));
        words.add(new Wordphrases("My name is...", "oyaaset..."));
        words.add(new Wordphrases("How are you feeling?", "michәksәs?"));
        words.add(new Wordphrases("I’m feeling good.", "kuchi achit"));
        words.add(new Wordphrases("Are you coming?", "әәnәs'aa?"));
        words.add(new Wordphrases("Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new Wordphrases("I’m coming.", "әәnәm"));
        words.add(new Wordphrases("Let’s go.", "yoowutis"));
        words.add(new Wordphrases("Come here.", "әnni'nem"));

        ArrayList<Integer> numSound = new ArrayList<Integer>();
        numSound.add(R.raw.phrase_where_are_you_going);
        numSound.add(R.raw.phrase_what_is_your_name);
        numSound.add(R.raw.phrase_my_name_is);
        numSound.add(R.raw.phrase_how_are_you_feeling);
        numSound.add(R.raw.phrase_im_feeling_good);
        numSound.add(R.raw.phrase_are_you_coming);
        numSound.add(R.raw.phrase_yes_im_coming);
        numSound.add(R.raw.phrase_im_coming);
        numSound.add(R.raw.phrase_lets_go);
        numSound.add(R.raw.phrase_come_here);


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapterPhrases adapter = new WordAdapterPhrases(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootview.findViewById(R.id.listnumbers);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mmediaPlayer = MediaPlayer.create(getActivity(), numSound.get(position));
                    mmediaPlayer.start();
                    mmediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });



        return rootview;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer() {
        if (mmediaPlayer != null) {
            mmediaPlayer.release();
            mmediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);

        }
    }
}