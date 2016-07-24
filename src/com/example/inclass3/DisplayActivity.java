package com.example.inclass3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends Activity {
	static String OPTIONS_KEY = "option";
	int REQ_CODE = 1001;
private EditOptions editOptions;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		Intent intent = getIntent();
		if (intent.getExtras() != null) {
			Student student = (Student) intent.getExtras().get(
					MainActivity.NAME_KEY);
			((TextView) findViewById(R.id.textViewName)).setText(student
					.getName());
			((TextView) findViewById(R.id.textViewEmail)).setText(student
					.getEmailID());
			((TextView) findViewById(R.id.textViewProLang)).setText(student
					.getProgLang());
			((TextView) findViewById(R.id.textViewAccount)).setText(student
					.isState() == true ? "Searchable" : "Unsearchable");
			((TextView) findViewById(R.id.textViewMood)).setText(student
					.getMood() * 10 + "% Positive");
		}
	}

	public void editClicked(View view){
		int id = view.getId();
	   editOptions = EditOptions.NAME;
		switch(id){
		case R.id.imageButtonName:
			editOptions = EditOptions.NAME;
			break;
		case R.id.imageButtonEmail:
			editOptions = EditOptions.EMAIL;
			break;
		case R.id.imageButtonPL:
			editOptions = EditOptions.PL;
			break;
		case R.id.imageButtonAccntState:
			editOptions = EditOptions.ACCNTSTATE;
			break;
		case R.id.imageButtonMood:
			editOptions = EditOptions.MOOD;
			
		}
		Intent intent = new Intent("com.example.inclass3.intent.action.EDIT");
		intent.putExtra(OPTIONS_KEY, editOptions);
		startActivityForResult(intent, REQ_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQ_CODE){
			data.getExtras().get("result");
		}
	}
	
}
