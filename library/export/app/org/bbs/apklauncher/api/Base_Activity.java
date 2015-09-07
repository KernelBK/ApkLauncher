package org.bbs.apklauncher.api;

import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.app.ExpandableListActivity;
//do NOT edit this file, auto-generated.
import android.app.ActivityGroup;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

import org.bbs.apklauncher.emb.IntentHelper;

public class Base_Activity extends Activity {
	
	private static final String TAG = Base_Activity.class.getSimpleName();
	private Intent mIntent;

	public int getHostIdentifier(String name, String defType, String defPackage){
		int resId = -1;
		resId = getResources().getIdentifier(name, defType, defPackage);
		
//do NOT edit this file, auto-generated.
		return resId;
	}
		
	//@Override
	public Base_Activity getHostActivity() {
		return this;
	}
	
	//@Override
	public Intent getIntent() {
		if (null == mIntent) {
			mIntent = new IntentHelper(super.getIntent());
		}
		return mIntent;
		
//		return super.getIntent();
	}
//do NOT edit this file, auto-generated.
}
