package com.bigtle.uvas2016;
 
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
 
public class InstructionActivity extends Activity {
	
	public MediaPlayer audio;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction);
    	audio = MediaPlayer.create(this, R.raw.ins_music);
    	audio.start();
	}
	
    @Override
    protected void onStop() {
    	super.onStop();
    	if (audio != null) {
    		audio.stop();
    	}
    }
}