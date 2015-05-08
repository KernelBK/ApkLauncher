package org.bbs.apklauncher.api;

import android.app.Service;

import org.bbs.apklauncher.emb.auto_gen.Target_IntentService;
import org.bbs.apklauncher.emb.auto_gen.Target_Service;

public abstract class Base_Service extends Target_Service {
	
	private static final String TAG = Base_Service.class.getSimpleName();
	
	public int getHostIdentifier(String name, String defType, String defPackage){
		int resId = -1;
		resId = org.bbs.apklauncher.emb.Util.getContextImpl(this).getResources().getIdentifier(name, defType, defPackage);
		
		return resId;
	}
//do NOT edit this file, auto-generated.
}