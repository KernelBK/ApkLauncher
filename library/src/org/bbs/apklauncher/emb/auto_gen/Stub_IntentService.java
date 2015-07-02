package org.bbs.apklauncher.emb.auto_gen;

import org.bbs.apklauncher.ApkLauncher;
import org.bbs.apklauncher.AndroidUtil;
import org.bbs.apklauncher.ApkPackageManager;
import org.bbs.apklauncher.ReflectUtil;
import org.bbs.apklauncher.ResourcesMerger;
import org.bbs.apklauncher.TargetContext;
import org.bbs.apklauncher.emb.Host_Application;
import org.bbs.apkparser.PackageInfoX.ServiceInfoX;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
//do NOT edit this file, auto-generated from Stub_Service.java.template
import android.util.Log;

public class Stub_IntentService extends StubBase_IntentService {
	private static final String TAG = Stub_IntentService.class.getSimpleName();
	/**
	 * type {@link String}
	 */
	public static final String EXTRA_TARGET_COMPONENT_CLASS_NAME = ApkLauncher.EXTRA_TARGET_COMPONENT_CLASS_NAME;

	private ResourcesMerger mResourceMerger;
	private Application mRealApplication;
	private String mTargetServiceClassName;
	private PackageManager mRealSysPm;
	private ClassLoader mTargetClassLoader;
	private TargetContext mTargetContext;
	private Context mRealBaseContext;
	
//do NOT edit this file, auto-generated from Stub_Service.java.template
	// tag_start:IntentService
	public Stub_IntentService(String name) {
		super(name);
	}
	// tag_end:IntentService
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		mRealBaseContext = newBase;
		mTargetContext = new TargetContext(newBase);
		super.attachBaseContext(mTargetContext);
		
//do NOT edit this file, auto-generated from Stub_Service.java.template
		mRealSysPm = getPackageManager();
	}
	
	protected void onPrepareServiceStub(Intent intent) {
		mTargetServiceClassName = intent.getStringExtra(EXTRA_TARGET_COMPONENT_CLASS_NAME);
		ServiceInfoX serviceInfo = ApkPackageManager.getInstance().getServiceInfo(mTargetServiceClassName);
		
		String apkPath = serviceInfo.applicationInfo.publicSourceDir;
		String libPath = serviceInfo.mPackageInfo.mLibPath;
		
		Log.d(TAG, "host service               : " + this);
		Log.d(TAG, "targetApplicationClassName : " + serviceInfo.applicationInfo.className);
		Log.d(TAG, "targetPackageName          : " + serviceInfo.packageName);
		Log.d(TAG, "targetServiceClassName     : " + mTargetServiceClassName);
		Log.d(TAG, "targetApkPath              : " + apkPath);
		Log.d(TAG, "targetLibPath              : " + libPath);
		
//do NOT edit this file, auto-generated from Stub_Service.java.template
		mTargetClassLoader = ApkPackageManager.getInstance()
												.createClassLoader(mRealBaseContext, 
																	apkPath, 
																	libPath,
																	serviceInfo.packageName);
		mTargetContext.classLoaderReady(mTargetClassLoader);
		
		// do application init. must before service init.
		Application app = ((Host_Application)getApplication()).onPrepareApplictionStub(serviceInfo.applicationInfo, 
																						mTargetClassLoader, mRealSysPm);
		
		try {
			mResourceMerger = ApkPackageManager.getTargetResource(apkPath, mRealBaseContext);
			
			mTargetContext.resReady(mResourceMerger);
//			mTargetContext.packageNameReady(serviceInfo.applicationInfo.packageName);
			
//do NOT edit this file, auto-generated from Stub_Service.java.template
			mTargetService = (Target_IntentService) mTargetClassLoader.loadClass(mTargetServiceClassName).newInstance();
				ReflectUtil.ActivityReflectUtil.attachBaseContext(mTargetService, 
						this
						);		
				if (DEBUG_LIEFT_CYCLE) {
					Log.d(TAG, "call target service onCreate().");
				}
				mTargetService.onCreate();
		} catch (Exception e) {
			throw new RuntimeException("error in create target service.  class: " + mTargetServiceClassName, e);
		}
	}
	
	@Override
	public Object getSystemService(String name) {
		if (Context.NOTIFICATION_SERVICE.equals(name) && null != mRealApplication) {
			return mRealApplication.getSystemService(name);
//do NOT edit this file, auto-generated from Stub_Service.java.template
		}
		return super.getSystemService(name);
	}
	
	@Override
	public Theme getTheme() {
		return mTargetContext.getTheme();
	}
	@Override
	public Resources getResources() {
		return mTargetContext.getResources();
	}
	
}
