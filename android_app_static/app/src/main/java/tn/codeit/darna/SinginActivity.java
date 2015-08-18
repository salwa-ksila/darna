package tn.codeit.darna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.example.android.effectivenavigation.R;

public class SinginActivity extends Activity {
	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signin, menu);
		//MenuItem menuItem = menu.findItem(R.id.action_share);
		// Fetch and store ShareActionProvider
		//mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
		// Call to update the share intent

			if (mShareActionProvider != null) {
				mShareActionProvider.setShareIntent(getDefaultIntent());
			}

		return true;
	}

	public Intent getDefaultIntent(){
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		return intent;

	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
