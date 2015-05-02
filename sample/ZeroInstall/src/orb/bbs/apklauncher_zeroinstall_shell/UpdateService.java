package orb.bbs.apklauncher_zeroinstall_shell;

import java.io.File;

import org.bbs.apklauncher.AndroidUtil;
import org.bbs.apklauncher.ApkPackageManager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.umeng.update.UmengDownloadListener;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateConfig;
import com.umeng.update.UpdateResponse;
import com.umeng.update.UpdateStatus;

public class UpdateService extends Service {

    private final String TAG = UpdateService.class.getSimpleName();

	protected ApkDonwloadMonitor mMonitor;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	private void checkUpdate() {
		UpdateConfig.setDebug(true);
        UpdateConfig.setDeltaUpdate(false);
        UmengUpdateAgent.setDownloadListener( new UmengDownloadListener(){

			@Override
			public void OnDownloadEnd(int arg0, String arg1) {
				Log.d(TAG, "OnDownloadEnd. arg0: " + arg0 + " arg1: " + arg1);
				if (UpdateStatus.DOWNLOAD_COMPLETE_FAIL == arg0 ) {
					mMonitor.onError();
				}
			}

			@Override
			public void OnDownloadStart() {
				Log.d(TAG, "OnDownloadStart. ");
				
			}

			@Override
			public void OnDownloadUpdate(int arg0) {
				Log.d(TAG, "OnDownloadUpdate. arg0: " + arg0);
				
			}});
        UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
            @Override
            public void onUpdateReturned(int updateStatus,UpdateResponse updateInfo) {
                switch (updateStatus) {
                    case UpdateStatus.Yes: // has update
//                        UmengUpdateAgent.showUpdateDialog(MainActivity.this, updateInfo);
                		
                		mMonitor = new ApkDonwloadMonitor(UpdateService.this, updateInfo);
                        mMonitor.start();
                        break;
                    case UpdateStatus.No: // has no update
                        Toast.makeText(UpdateService.this, "没有更新", Toast.LENGTH_SHORT).show();
                        break;
                    case UpdateStatus.NoneWifi: // none wifi
                        Toast.makeText(UpdateService.this, "没有wifi连接， 只在wifi下更新", Toast.LENGTH_SHORT).show();
                        break;
                    case UpdateStatus.Timeout: // java.lang.Stringtime out
                        Toast.makeText(UpdateService.this, "超时", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
           
        });
        
        UmengUpdateAgent.setUpdateAutoPopup(false);
        UmengUpdateAgent.update(this);
//        UmengUpdateAgent.silentUpdate(this);
	}
	
	
	
    @Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

        checkUpdate();
	}

	class ApkDonwloadMonitor extends Thread {
		private final  UpdateResponse mInfo;
        private final Context mContext;
		private boolean mError;

        public ApkDonwloadMonitor(Context context, UpdateResponse updateInfo) {
            mContext = context;
            mInfo = updateInfo;
        }
        
        public void onError(){
        	mError = true;
        }

        @Override
        public void run() {
            super.run();

            UmengUpdateAgent.downloadedFile(UpdateService.this, mInfo);

            while (UmengUpdateAgent.downloadedFile(mContext, mInfo) == null && !mError) {
                try {
                    sleep(500);
                    Log.e(TAG, "sleep..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            File apkFile = UmengUpdateAgent.downloadedFile(mContext, mInfo);
            if (null != apkFile) {
                apkFileReady(apkFile);
            } else {
            	Log.e(TAG, "error on download file: " + apkFile);
            }
        }

        private void apkFileReady(File apkFile) {
            Log.d(TAG, "apkFileReady: apkFile:" + apkFile);
            
            File update = new File(ApkPackageManager.getInstance().getAutoUpdatePluginDir(), "latest.apk");
            AndroidUtil.copyFile(apkFile, update);
            Log.d(TAG, "apkFileReady: update:" + update);
        }

    }
}
