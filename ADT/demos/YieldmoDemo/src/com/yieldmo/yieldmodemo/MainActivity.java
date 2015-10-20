package com.yieldmo.yieldmodemo;

import com.yieldmo.sdk.YMSdk;
import com.yieldmo.sdk.util.YMLogger;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		YMLogger.setLogLevel(YMLogger.LogLevel.Verbose);
        YMSdk.getInstance().initialize(getApplicationContext(), "10b289f8-df7d-11e3-a6a3-82687f4fc17c");

		Fragment fragment = new CodeDemoFragment();
		getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Fragment fragment;
		switch (item.getItemId()) {
		case R.id.action_code:
			fragment = new CodeDemoFragment();
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
			return true;
		case R.id.action_layout:
			fragment = new LayoutDemoFragment();
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
			return true;
		case R.id.action_about:
			fragment = new AboutFragment();
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
			return true;
		}
		
		return false;
	}
}
