package org.bbs.apklauncher.emb.auto_gen;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import org.bbs.apklauncher.ReflectUtil.ActivityReflectUtil;


import org.bbs.apklauncher.TargetClassLoaderCreator;
import org.bbs.apklauncher.ApkUtil;
import org.bbs.apklauncher.ApkLauncher;
import org.bbs.apklauncher.ApkLauncherConfig;
import org.bbs.apklauncher.AndroidUtil;
import org.bbs.apklauncher.ApkPackageManager;
import org.bbs.apklauncher.PackageManagerProxy;
import org.bbs.apklauncher.emb.Host_Application;
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
import org.bbs.apklauncher.emb.IntentHelper;
import org.bbs.apklauncher.ViewCreater;
import org.bbs.apklauncher.emb.auto_gen.Target_Activity;
import org.bbs.apkparser.PackageInfoX.ActivityInfoX;
import org.bbs.apklauncher.TargetInstrumentation;
import org.bbs.apklauncher.TargetInstrumentation.CallBack;
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
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.text.TextUtils;
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
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
	public static final String EXTRA_HOST_COMPONENT_CLASS_NAME = ApkLauncher.EXTRA_HOST_COMPONENT_CLASS_NAME;
	/**
	 * type {@link String}
	 */
	public static final String EXTRA_TARGET_COMPONENT_CLASS_NAME = ApkLauncher.EXTRA_TARGET_COMPONENT_CLASS_NAME;
	
	private static final String TAG = StubBase_FragmentActivity.class.getSimpleName();
	
	protected ClassLoader     mTargetClassLoader;
	protected TargetContext   mTargetContext;
	protected ActivityInfoX   mTargetActivityInfo;
	protected ResourcesMerger mTargetResourceMerger;
	
	protected PackageManager  mHostSysPm;
	protected Context 	    mHostBaseContext;	
	protected ClassLoader     mHostClassLoader;
	
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
	private IntentHelper    mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		onPrepareActivityStub();
		
		super.onCreate(savedInstanceState);
		
		ApkUtil.updateTitle(this, mTargetActivityInfo, mTargetResourceMerger);
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		mHostBaseContext = newBase;
		mTargetContext = new TargetContext(newBase);
		super.attachBaseContext(mTargetContext);
		mHostClassLoader = AndroidUtil.getContextImpl(this).getClassLoader();
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		
		mHostSysPm = getPackageManager();
	}

	private void onPrepareActivityStub() {
		
		Intent intent = getIntent();
		// TODO is there a way to update ClassLoader before parse intent?
		//intent.getExtras().setClassLoader(loader);
		
		String hostActivityClassName = intent.getStringExtra(EXTRA_HOST_COMPONENT_CLASS_NAME);
		// get target activity info
		String targetActivityClassName = intent.getStringExtra(EXTRA_TARGET_COMPONENT_CLASS_NAME);
		mTargetActivityInfo = ApkPackageManager.getInstance()
												.getActivityInfo(targetActivityClassName);
		String libPath = mTargetActivityInfo.mPackageInfo.applicationInfo.nativeLibraryDir;
		String targetApplicationClassName = mTargetActivityInfo.applicationInfo.className;
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		int targetThemeId = mTargetActivityInfo.theme;
		String apkPath = mTargetActivityInfo.applicationInfo.publicSourceDir;
		String targetPackageName = mTargetActivityInfo.packageName;

		if (ApkLauncherConfig.debug()) {
			Log.d(TAG, "stub activity              : " + Stub_Activity.class.getName());
			Log.d(TAG, "host activity              : " + hostActivityClassName);
			Log.d(TAG, "targetActivityClassName    : " + targetActivityClassName);
			Log.d(TAG, "targetThemeId              : " + targetThemeId);
			Log.d(TAG, "targetApkPath              : " + apkPath);
			Log.d(TAG, "targetLibPath              : " + libPath);
			Log.d(TAG, "targetApplicationClassName : " + targetApplicationClassName);
			Log.d(TAG, "targetPackageName          : " + targetPackageName);
		}
		
		// create target classloader if necessary.
//		mTargetClassLoader = ApkPackageManager.getInstance()
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
//									.createClassLoader(mHostBaseContext, 
//														apkPath, 
//														libPath, 
//														targetPackageName);
		mTargetClassLoader = createTargetClassLoader(mHostBaseContext, intent);
		mTargetContext.classLoaderReady(mTargetClassLoader);

		// do application init. must before activity init.
		Application targetApp = ((Host_Application)getApplication())
								.onPrepareApplictionStub(mTargetActivityInfo.applicationInfo, 
														 mTargetClassLoader, 
														 mHostSysPm);
		
		// do activity init
		TargetInstrumentation.injectInstrumentation(this, this);
		try {
			mTargetResourceMerger = ApkPackageManager.getTargetResource(apkPath, mHostBaseContext);
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template

			targetThemeId = ReflectUtil.ResourceUtil
											.selectDefaultTheme(mTargetResourceMerger, 
																targetThemeId, 
															 	mTargetActivityInfo.applicationInfo.targetSdkVersion);

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
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
			mTargetActivity.setHostActivity(this);
			ReflectUtil.ActivityReflectUtil.attachBaseContext(mTargetActivity, this);
		} catch (Exception e) {
			throw new RuntimeException("error in create activity: " + targetActivityClassName , e);
		}		
	}	
		
	protected ClassLoader createTargetClassLoader(Context hostBaseContext, Intent intent) {
		return TargetClassLoaderCreator.createTargetClassLoader(hostBaseContext, intent);
	}
	
	@Override
	public Intent getIntent() {
		if (null == mIntent) {
			mIntent = new IntentHelper(super.getIntent());
		}
		return mIntent;
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
		
//		return super.getIntent();
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
		return mTargetContext.getResources();
	}

	@Override
//do NOT edit this file, auto-generated by host_target.groovy from Target_Activity.java.template
	public void onProcessIntent(android.content.Intent intent) {
		 ApkLauncher.getInstance().onProcessIntent(intent, mTargetClassLoader, mHostBaseContext);
	}
	
	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		View view = super.onCreateView(name, context, attrs);
		return view != null ? view 
							: ViewCreater.onCreateView(name, context, attrs, mHostClassLoader, mTargetClassLoader, mTargetActivity);
	}
}
