package com.example.inclass3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

public class EditActivity extends Activity {

	private EditOptions editOptions;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		Intent intent = getIntent();
		if(intent.getExtras() != null){
		 editOptions = (EditOptions)(intent.getExtras().get(DisplayActivity.OPTIONS_KEY));
			if(editOptions == EditOptions.NAME){
				findViewById(R.id.name).setVisibility(View.VISIBLE);
			}else if (editOptions == EditOptions.EMAIL){
				findViewById(R.id.email).setVisibility(View.VISIBLE);
			}else if (editOptions == EditOptions.PL){
				findViewById(R.id.textView1).setVisibility(View.VISIBLE);
				findViewById(R.id.radioGroup1).setVisibility(View.VISIBLE);
			}else if (editOptions == EditOptions.ACCNTSTATE){
				findViewById(R.id.switch1).setVisibility(View.VISIBLE);
			}else if (editOptions == EditOptions.MOOD){
				findViewById(R.id.textView2).setVisibility(View.VISIBLE);
				findViewById(R.id.seekBar1).setVisibility(View.VISIBLE);
			}
		}
	}
	public void saveClicked(View view){
		Intent intent = new Intent();
		String result="";
		if(editOptions == EditOptions.NAME){
			result = ((EditText)findViewById(R.id.name)).getText().toString();
		}else if (editOptions == EditOptions.EMAIL){
			result = ((EditText)findViewById(R.id.email)).getText().toString();
		}else if (editOptions == EditOptions.PL){
			int radioId = ((RadioGroup)findViewById(R.id.radioGroup1)).getCheckedRadioButtonId();
			if(radioId == R.id.radioC)
				result = "C";
				else if (radioId == R.id.radioCsh)
					result = "C#";
				else
					result = "Java";
		}else if (editOptions == EditOptions.ACCNTSTATE){
			result = new Boolean(((Switch)findViewById(R.id.switch1)).isChecked()).toString();
		}else if (editOptions == EditOptions.MOOD){
			result = new Integer(((SeekBar)findViewById(R.id.seekBar1)).getProgress()).toString();
		}

		intent.putExtra("result", result);
		setResult(RESULT_OK, intent);
	}
}
