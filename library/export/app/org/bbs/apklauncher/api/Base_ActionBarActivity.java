package org.bbs.apklauncher.api;

//do NOT edit this file, auto-generated.
import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.app.ExpandableListActivity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

import org.bbs.apklauncher.emb.IntentHelper;

public class Base_ActionBarActivity extends ActionBarActivity {
	
	private static final String TAG = Base_ActionBarActivity.class.getSimpleName();
	private Intent mIntent;

//do NOT edit this file, auto-generated.
	public int getHostIdentifier(String name, String defType, String defPackage){
		int resId = -1;
		resId = getResources().getIdentifier(name, defType, defPackage);
		
		return resId;
	}
		
	//@Override
	public Base_ActionBarActivity getHostActivity() {
		return this;
	}
	
	//@Override
	public Intent getIntent() {
		if (null == mIntent) {
			mIntent = new IntentHelper(super.getIntent());
		}
//do NOT edit this file, auto-generated.
		return mIntent;
		
//		return super.getIntent();
	}
}
