package com.example.inclass3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends Activity {

	static String NAME_KEY = "student";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void submitButtonClicked(View v){
		Student student=new Student();
		student.setName(((EditText)findViewById(R.id.name)).getText().toString());
		student.setEmailID(((EditText)findViewById(R.id.email)).getText().toString());
		int radioId = ((RadioGroup)findViewById(R.id.radioGroup1)).getCheckedRadioButtonId();
		if(radioId == R.id.radioC)
		student.setProgLang("C");
		else if (radioId == R.id.radioCsh)
			student.setProgLang("C#");
		else
			student.setProgLang("Java");
		student.setState(((Switch)findViewById(R.id.switch1)).isChecked());
		student.setMood(((SeekBar)findViewById(R.id.seekBar1)).getProgress());

		Intent intent = new Intent(this, DisplayActivity.class);
		intent.putExtra(NAME_KEY, student);
		startActivity(intent);
		
	}
}
