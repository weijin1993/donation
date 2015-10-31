package app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import app.activities.R;

public class Donate extends Activity {
	  private int          totalDonated = 0;
	  private Button       donateButton;
	  private RadioGroup   paymentMethod;
	  private ProgressBar  progressBar;
	  private NumberPicker amountPicker;
	  private TextView     amountText;
	  private TextView     amountTotal;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);
		
		donateButton  = (Button)       findViewById(R.id.donateButton);
	    paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
	    progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
	    amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);

	    amountPicker.setMinValue(0);
	    amountPicker.setMaxValue(1000);
	    progressBar.setMax(10000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate, menu);
		return true;
	}

	  @Override
	  public boolean onOptionsItemSelected(MenuItem item)
	  {
	    switch (item.getItemId())
	    {
	      case R.id.menuReport : startActivity (new Intent(this, Report.class));
	                             break;
	    }
	    return true;
	  }
	
	public void donateButtonPressed (View view) 
	  {
	    int amount = amountPicker.getValue();
	    int radioId = paymentMethod.getCheckedRadioButtonId();
	    String method = "";
	    if (radioId == R.id.PayPal)
	    {
	      method = "PayPal";
	    }
	    else
	    {
	      method = "Direct";
	    }
	    Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
	    totalDonated = totalDonated + amount;
	    progressBar.setProgress(totalDonated);
	  }
}
