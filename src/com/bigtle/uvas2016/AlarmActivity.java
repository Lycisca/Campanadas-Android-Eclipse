package com.bigtle.uvas2016;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;

public class AlarmActivity extends Activity {

	Button buttonLink;
	Button buttonInstructions;
	public MediaPlayer init_music;
	
	private AlarmReceiver alarm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_alarm_manager);
		addListenerOnButtons();

        alarm = new AlarmReceiver();
        Context context = this.getApplicationContext();
        alarm.setOnetimeTimer(context);
        
        super.onCreate(savedInstanceState);
    }
    
    @Override
	protected void onStart() {
    	init_music = MediaPlayer.create(this, R.raw.init_music);
    	init_music.start();
		super.onStart();
	}
    
    @Override
    protected void onStop() {
    	super.onStop();
    	if (init_music != null) {
    		init_music.stop();
    	}
    }
       
    // Botones link e instrucciones
    public void addListenerOnButtons() {
		buttonLink = (Button) findViewById(R.id.button1);
		buttonLink.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			  Intent browserIntent = 
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://vimeo.com/149971650"));
			      startActivity(browserIntent);
			}
		});
		
		buttonInstructions = (Button) findViewById(R.id.button2);
		buttonInstructions.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent myIntent = 
				  new Intent(AlarmActivity.this, InstructionActivity.class);
					startActivity(myIntent);
			}
		});
	}
}
