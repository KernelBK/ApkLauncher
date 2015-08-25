package org.bbs.apklauncher.demo;
import java.io.File;
import org.bbs.apklauncher.AndroidUtil;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BackUpActivity extends Activity {
	private static final String TAG = BackUpActivity.class.getSimpleName();
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.apklauncher_activity_plugins);

		ListAdapter adapter = new ArrayAdapter<ApplicationInfo>(this, android.R.layout.simple_list_item_1, (getPackageManager().getInstalledApplications(0))){
			@Override
			public View getView(final int position, View convertView, ViewGroup parent) {
				View v =  super.getView(position, convertView, parent);
				
				v.setTag(getItem(position));
				v.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						v.setTag(getItem(position));
						ApplicationInfo a = (ApplicationInfo) v.getTag();
						
						Log.d(TAG, "onClick. activity: " + a);
						File apkFile = new File(a.sourceDir);
						File DIR = new File("/sdcard/apk");
						DIR.mkdirs();
						File backupFile = new File(DIR, a.packageName + ".apk");
						AndroidUtil.copyFile(apkFile, backupFile);
						Toast.makeText(BackUpActivity.this, "scr:" + apkFile + " backFile: " + backupFile, Toast.LENGTH_LONG).show();;
						
					}
				});
				return v ;
			}
		};
		((ListView)findViewById(R.id.apk_container)).setAdapter(adapter);;
		((ListView)findViewById(R.id.apk_container)).setEmptyView(findViewById(android.R.id.empty));;		

		String s = getSharedPreferences("TEST", MODE_MULTI_PROCESS).getString("KEY", "no found.");
		Log.d(TAG, "sp: " + s);
		getSharedPreferences("TEST", 0).edit().putString("KEY", "hello backup").apply();
	}
	
}
