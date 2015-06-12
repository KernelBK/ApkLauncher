package org.bbs.apklauncher.emb.auto_gen;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import org.bbs.apklauncher.ReflectUtil.ActivityReflectUtil;

import org.bbs.apklauncher.ApkLauncher;
import org.bbs.apklauncher.AndroidUtil;
import org.bbs.apklauncher.ApkPackageManager;
import org.bbs.apklauncher.PackageManagerProxy;
import org.bbs.apklauncher.emb.Host_Application;
import org.bbs.apklauncher.emb.IntentHelper;
import org.bbs.apklauncher.ViewCreater;
import org.bbs.apklauncher.emb.auto_gen.Target_Activity;
import org.bbs.apkparser.PackageInfoX.ActivityInfoX;
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
import org.bbs.apklauncher.InstrumentationWrapper;
import org.bbs.apklauncher.InstrumentationWrapper.CallBack;
import org.bbs.apklauncher.ReflectUtil;
import org.bbs.apklauncher.ResourcesMerger;
import org.bbs.apklauncher.TargetContext;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.text.TextUtils;
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import dalvik.system.DexClassLoader;

// keep logic outside of this as many as possible.
public class Stub_FragmentActivity extends 
StubBase_FragmentActivity
implements CallBack {

	/**
	 * type {@link String}
	 */
	public static final String EXTRA_HOST_COMPONENT_CLASS_NAME = ApkLauncher.EXTRA_HOST_COMPONENT_CLASS_NAME;
	/**
	 * type {@link String}
	 */
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
	public static final String EXTRA_TARGET_COMPONENT_CLASS_NAME = ApkLauncher.EXTRA_TARGET_COMPONENT_CLASS_NAME;
	
	private static final String TAG = StubBase_FragmentActivity.class.getSimpleName();
	
	private ClassLoader     mTargetClassLoader;
	private TargetContext   mTargetContext;
	private ActivityInfoX   mTargetActivityInfo;
	private ResourcesMerger mTargetResourceMerger;
	
	private PackageManager  mHostSysPm;
	private Context 	    mHostBaseContext;	
	
	private IntentHelper    mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		onPrepareActivityStub();
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		
		super.onCreate(savedInstanceState);
		
		updateTitle();
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		mHostBaseContext = newBase;
		mTargetContext = new TargetContext(newBase);
		super.attachBaseContext(mTargetContext);
		
		mHostSysPm = getPackageManager();
	}

	private void onPrepareActivityStub() {
		
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		Intent intent = getIntent();
		// TODO is there a way to update ClassLoader before parse intent?
		//intent.getExtras().setClassLoader(loader);
		
		String hostActivityClassName = intent.getStringExtra(EXTRA_HOST_COMPONENT_CLASS_NAME);
		// get target activity info
		String targetActivityClassName = intent.getStringExtra(EXTRA_TARGET_COMPONENT_CLASS_NAME);
		mTargetActivityInfo = ApkPackageManager.getInstance()
												.getActivityInfo(targetActivityClassName);
		String libPath = mTargetActivityInfo.mPackageInfo.mLibPath;
		String targetApplicationClassName = mTargetActivityInfo.applicationInfo.className;
		int targetThemeId = mTargetActivityInfo.theme;
		String apkPath = mTargetActivityInfo.applicationInfo.publicSourceDir;
		if (TextUtils.isEmpty(targetApplicationClassName)){
			targetApplicationClassName = Application.class.getCanonicalName();
			Log.d(TAG, "no packageName, user default.");
		}
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		String targetPackageName = mTargetActivityInfo.packageName;

		Log.d(TAG, "stub activity              :" + this);
		Log.d(TAG, "host activity              : " + hostActivityClassName);
		Log.d(TAG, "targetApplicationClassName : " + targetApplicationClassName);
		Log.d(TAG, "targetPackageName          : " + targetPackageName);
		Log.d(TAG, "targetActivityClassName    : " + targetActivityClassName);
		Log.d(TAG, "targetThemeId              : " + targetThemeId);
		Log.d(TAG, "targetApkPath              : " + apkPath);
		Log.d(TAG, "targetLibPath              : " + libPath);
		
		// create target classloader if necessary.
		mTargetClassLoader = ApkPackageManager.getInstance()
									.createClassLoader(mHostBaseContext, 
														apkPath, 
														libPath, 
														targetPackageName);
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		mTargetContext.classLoaderReady(mTargetClassLoader);

		// do application init. must before activity init.
		Application targetApp = ((Host_Application)getApplication())
								.onPrepareApplictionStub(mTargetActivityInfo.applicationInfo, 
														 mTargetClassLoader, 
														 mHostSysPm);
		
		// do activity init
		InstrumentationWrapper.injectInstrumentation(this, this);
		try {
			mTargetResourceMerger = ApkPackageManager.makeTargetResource(apkPath, mHostBaseContext);

			targetThemeId = ReflectUtil.ResourceUtil
											.selectDefaultTheme(mTargetResourceMerger, 
																targetThemeId, 
															 	mTargetActivityInfo.applicationInfo.targetSdkVersion);
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template

			Log.d(TAG, "resolved activity theme: " + targetThemeId);
			mTargetContext.setTheme(targetThemeId);
			mTargetContext.themeReady(targetThemeId);
			mTargetContext.resReady(mTargetResourceMerger);
			mTargetContext.applicationContextReady(ApkPackageManager.getApplication(targetPackageName));
			mTargetContext.packageManagerReady(new PackageManagerProxy(mHostSysPm));
			mTargetContext.packageNameReady(targetPackageName);
			
			ReflectUtil.ActivityReflectUtil.setActivityApplication(this, targetApp);
			Class clazz = mTargetClassLoader.loadClass(targetActivityClassName);
			mTargetActivity = (Target_FragmentActivity) clazz.newInstance();
			mTargetActivity.setHostActivity(this);
			ReflectUtil.ActivityReflectUtil.attachBaseContext(mTargetActivity, this);
		} catch (Exception e) {
			throw new RuntimeException("error in create activity: " + targetActivityClassName , e);
		}		
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
	}
	
	@Override
	public Intent getIntent() {
		if (null == mIntent) {
			mIntent = new IntentHelper(super.getIntent());
		}
		return mIntent;
		
//		return super.getIntent();
	}

	private void updateTitle() {
		CharSequence title = "";
		if (mTargetActivityInfo.labelRes  > 0) {
			title = mTargetResourceMerger.getString(mTargetActivityInfo.labelRes);
		}
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		if (TextUtils.isEmpty(title)) {
			title = mTargetActivityInfo.nonLocalizedLabel;
		}
		if (!TextUtils.isEmpty(title)) {
			setTitle(title);
		}
	}

	// XXX are we need this really???
	// Activity extends ContextThemeWrapper which had these 2 methods,
	// so we override those with ours.
	@Override
	public Theme getTheme() {
		return mTargetContext.getTheme();
	}
	@Override
	public Resources getResources() {
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		return mTargetContext.getResources();
	}

	@Override
	public void onProcessIntent(android.content.Intent intent) {
		 ApkLauncher.getInstance().onProcessIntent(intent, mTargetClassLoader, mHostBaseContext);
	}
	
	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		View view = super.onCreateView(name, context, attrs);
		return view != null ? view 
							: ViewCreater.onCreateView(name, context, attrs, mTargetClassLoader, mTargetActivity);
	}
}
