package org.bbs.apklauncher.api;

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

//do NOT edit this file, auto-generated.
public class Base_PreferenceActivity extends PreferenceActivity {
	
	private static final String TAG = Base_PreferenceActivity.class.getSimpleName();
	private Intent mIntent;

	public int getHostIdentifier(String name, String defType, String defPackage){
		int resId = -1;
		resId = getResources().getIdentifier(name, defType, defPackage);
		
		return resId;
	}
		
	//@Override
	public Base_PreferenceActivity getHostActivity() {
		return this;
	}
	
//do NOT edit this file, auto-generated.
	//@Override
	public Intent getIntent() {
		if (null == mIntent) {
			mIntent = new IntentHelper(super.getIntent());
		}
		return mIntent;
		
//		return super.getIntent();
	}
}
