package org.bbs.apklauncher.emb.auto_gen;

import java.util.List;

import org.bbs.apklauncher.ReflectUtil.ActivityReflectUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.app.Fragment;
import android.app.ListActivity;
import android.app.TabActivity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

/**
 * delegate android framework's method call to {@link #mTargetActivity}
 * @author luoqii
 *
 */
@SuppressLint("NewApi")
public class StubBase_ActivityGroup extends ActivityGroup {
	private static final String TAG = StubBase_ActivityGroup.class.getSimpleName();
	
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	private static boolean LOG = true;
	
	// keep "stub" lower-case.
	private static boolean LOG_stub = true && LOG;
	
	private static boolean LOG_LIFECYCLE = false && LOG;
	private static boolean LOG_MENU = false && LOG;
	private static boolean LOG_CONTENT = true && LOG;
	private static boolean LOG_DIALOG = true && LOG;
	private static boolean LOG_KEY_EVENT = true && LOG;
	private static boolean LOG_MOTTION_EVENT = true && LOG;
	
	protected  Target_ActivityGroup mTargetActivity;	
	
	public Target_ActivityGroup getTargetActivity(){
		return mTargetActivity;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTargetActivity.onCreate(savedInstanceState);;		
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onCreate(). savedInstanceState: " + savedInstanceState);
		}
	}

//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	@Override
	public void onCreate(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		mTargetActivity.onCreate(savedInstanceState, persistentState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onCreate(). persistentState: " + persistentState + " persistentState: " + persistentState );
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mTargetActivity.onRestoreInstanceState(savedInstanceState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onRestoreInstanceState(). savedInstanceState: " + savedInstanceState);
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		mTargetActivity.onRestoreInstanceState(savedInstanceState, persistentState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onRestoreInstanceState(). persistentState: " + persistentState + " persistentState: " + persistentState );
		}
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mTargetActivity.onPostCreate(savedInstanceState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onPostCreate(). savedInstanceState: " + savedInstanceState);
		}
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onPostCreate(savedInstanceState, persistentState);
		mTargetActivity.onPostCreate(savedInstanceState, persistentState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onPostCreate(). persistentState: " + persistentState + " persistentState: " + persistentState );
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		mTargetActivity.onStart();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onStart(). " );
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		}
	}

	@Override
	protected void onRestart() {
		super.onStart();
		mTargetActivity.onRestart();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onRestart(). " );
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		mTargetActivity.onResume();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onResume(). " );
		}
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		mTargetActivity.onPostResume();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onPostResume(). " );
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		}
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		mTargetActivity.onNewIntent(intent);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onNewIntent(). intent: " + intent );
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mTargetActivity.onSaveInstanceState(outState);
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onSaveInstanceState(). outState: " + outState );
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState,
			PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
		mTargetActivity.onSaveInstanceState(outState, outPersistentState);
		if (LOG_LIFECYCLE) {
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		    _log(TAG, "call mTargetActivity onSaveInstanceState(). outState: " + outState  + " outPersistentState: " + outPersistentState);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		mTargetActivity.onPause();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onPause(). " );
		}
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		mTargetActivity.onUserLeaveHint();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onUserLeaveHint(). " );
		}
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		boolean created =  super.onCreateThumbnail(outBitmap, canvas);
		return created ? true : mTargetActivity.onCreateThumbnail(outBitmap, canvas);
	}
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template

	@Override
	public CharSequence onCreateDescription() {
		CharSequence c =  super.onCreateDescription();
		return TextUtils.isEmpty(c) ? mTargetActivity.onCreateDescription() : c;
	}

	@Override
	public void onProvideAssistData(Bundle data) {
		super.onProvideAssistData(data);
		mTargetActivity.onProvideAssistData(data);
	}

	@Override
	protected void onStop() {
		super.onStop();
		mTargetActivity.onStop();
		if (LOG_LIFECYCLE) {
		    _log(TAG, "call mTargetActivity onStop(). " );
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mTargetActivity.onDestroy();
		if (LOG_LIFECYCLE) {
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		    _log(TAG, "call mTargetActivity onDestroy(). " );
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mTargetActivity.onConfigurationChanged(newConfig);
		
		if (LOG) {
			_log(TAG, "onConfigurationChanged(). config: " + newConfig);
		}
	}
	// tag_start:No_ActionBarActivity
	// tag_start:No_FragmentActivity
	@Override
	public Object onRetainNonConfigurationInstance() {
//		return super.onRetainNonConfigurationInstance();
		return mTargetActivity.onRetainNonConfigurationInstance();
	}
	// tag_end:No_FragmentActivity
	// tag_end:No_ActionBarActivity

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mTargetActivity.onLowMemory();
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		mTargetActivity.onTrimMemory(level);
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		mTargetActivity.onAttachFragment(fragment);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		boolean handled =  super.onKeyDown(keyCode, event);
		return !handled ? mTargetActivity.onKeyDown(keyCode, event) : handled;
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		boolean handled =  super.onKeyLongPress(keyCode, event);
		return !handled ? mTargetActivity.onKeyLongPress(keyCode, event) : handled;
	}

	@Override
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		boolean handled =  super.onKeyUp(keyCode, event);
		return !handled ? mTargetActivity.onKeyUp(keyCode, event) : handled;
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		boolean handled =  super.onKeyMultiple(keyCode, repeatCount, event);
		return !handled ? mTargetActivity.onKeyMultiple(keyCode, repeatCount, event) : handled;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
//		mTargetActivity.onBackPressed();
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		boolean handled =  super.onKeyShortcut(keyCode, event);
		return !handled ? mTargetActivity.onKeyShortcut(keyCode, event) : handled;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean handled =  super.onTouchEvent(event);
		return !handled ? mTargetActivity.onTouchEvent(event) : handled;
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		boolean handled =  super.onTrackballEvent(event);
		return !handled ? mTargetActivity.onTrackballEvent(event) : handled;
	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		boolean handled =  super.onGenericMotionEvent(event);
		return !handled ? mTargetActivity.onGenericMotionEvent(event) : handled;
	}

	@Override
	public void onUserInteraction() {
		super.onUserInteraction();
		mTargetActivity.onUserInteraction();
	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		super.onWindowAttributesChanged(params);
		mTargetActivity.onWindowAttributesChanged(params);
	}

//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	// tag_start:No_ActionBarActivity
	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mTargetActivity.onContentChanged();
	}
	// tag_end:No_ActionBarActivity

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		mTargetActivity.onWindowFocusChanged(hasFocus);
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		mTargetActivity.onAttachedToWindow();
	}

	@Override
	public void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mTargetActivity.onDetachedFromWindow();
	}

	@Override
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	public boolean dispatchKeyEvent(KeyEvent event) {
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		boolean handled =  super.dispatchKeyShortcutEvent(event);
		return !handled ? mTargetActivity.dispatchKeyShortcutEvent(event) : handled;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		boolean handled =  super.dispatchTouchEvent(ev);
		return !handled ? mTargetActivity.dispatchTouchEvent(ev) : handled;
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		boolean handled =  super.dispatchTouchEvent(ev);
		return !handled ? mTargetActivity.dispatchTrackballEvent(ev) : handled;
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		boolean handled =  super.dispatchGenericMotionEvent(ev);
		return !handled ? mTargetActivity.dispatchGenericMotionEvent(ev) : handled;
	}
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		boolean handled =  super.dispatchPopulateAccessibilityEvent(event);
		return !handled ? mTargetActivity.dispatchPopulateAccessibilityEvent(event) : handled;
	}

	@Override
	public View onCreatePanelView(int featureId) {
		View view =  mTargetActivity.onCreatePanelView(featureId);
		return view != null ? view : super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		boolean show =  mTargetActivity.onCreatePanelMenu(featureId, menu);
		return show ? true : super.onCreatePanelMenu(featureId, menu);
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		boolean show =  mTargetActivity.onPreparePanel(featureId, view, menu);
		return show ? true : super.onPreparePanel(featureId, view, menu);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		boolean show = mTargetActivity.onMenuOpened(featureId, menu);
		return show ? true : super.onMenuOpened(featureId, menu);
	}

	// tag_start:No_ActionBarActivity
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		boolean finish = mTargetActivity.onMenuItemSelected(featureId, item);
		return finish ? true : super.onMenuItemSelected(featureId, item);
	}	
	// tag_end:No_ActionBarActivity

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		mTargetActivity.onPanelClosed(featureId, menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean show =  mTargetActivity.onCreateOptionsMenu(menu);
		return show ? true : super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean show = mTargetActivity.onPrepareOptionsMenu(menu);
		return show ? true : super.onPrepareOptionsMenu(menu);
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean handled = mTargetActivity.onOptionsItemSelected(item);
		return handled ? true : super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigateUp() {
		boolean todo = mTargetActivity.onNavigateUp();
		return todo ? true : super.onNavigateUp();
	}

	@Override
	public boolean onNavigateUpFromChild(Activity child) {
		boolean todo = mTargetActivity.onNavigateUpFromChild(child);
		return todo ? true : super.onNavigateUpFromChild(child);
	}

	@Override
	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
		mTargetActivity.onCreateNavigateUpTaskStack(builder);
		super.onCreateNavigateUpTaskStack(builder);
	}

	@Override
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
		mTargetActivity.onPrepareNavigateUpTaskStack(builder);
		super.onPrepareNavigateUpTaskStack(builder);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		mTargetActivity.onOptionsMenuClosed(menu);
		super.onOptionsMenuClosed(menu);
	}

	@Override
	public void openOptionsMenu() {
		mTargetActivity.openOptionsMenu();
		super.openOptionsMenu();
	}

	@Override
	public void closeOptionsMenu() {
		mTargetActivity.closeOptionsMenu();
		super.closeOptionsMenu();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		mTargetActivity.onCreateContextMenu(menu, v, menuInfo);
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		boolean consumed =  mTargetActivity.onContextItemSelected(item);
		return consumed ? true : super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		mTargetActivity.onContextMenuClosed(menu);
		super.onContextMenuClosed(menu);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dia =  mTargetActivity.onCreateDialog(id);
		return dia != null ? dia : super.onCreateDialog(id);
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		Dialog dia = mTargetActivity.onCreateDialog(id, args);
		return dia != null ? dia : super.onCreateDialog(id, args);
	}

//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		mTargetActivity.onPrepareDialog(id, dialog);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		super.onPrepareDialog(id, dialog, args);
//		mTargetActivity.onPrepareDialog(id, dialog, args);
	}

	@Override
	public boolean onSearchRequested() {
		boolean launched =  mTargetActivity.onSearchRequested();
		return launched ? true : super.onSearchRequested();
	}

	@Override
	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		super.onApplyThemeResource(theme, resid, first);		
		if (null != mTargetActivity) {
			mTargetActivity.onApplyThemeResource(theme, resid, first);
		}
	}

	@Override
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		super.overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		mTargetActivity.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onActivityReenter(int resultCode, Intent data) {
		super.onActivityReenter(resultCode, data);
		mTargetActivity.onActivityReenter(resultCode, data);
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		super.onTitleChanged(title, color);
		mTargetActivity.onTitleChanged(title, color);
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
		mTargetActivity.onChildTitleChanged(childActivity, title);
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		View view = mTargetActivity.onCreateView(name, context, attrs);
		return view != null ? view : super.onCreateView(name, context, attrs);
	}

	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		View view = mTargetActivity.onCreateView(parent, name, context, attrs);
		return view != null ? view : super.onCreateView(parent, name, context, attrs);
	}

	@Override
	public void onVisibleBehindCanceled() {
		super.onVisibleBehindCanceled();
		mTargetActivity.onVisibleBehindCanceled();
	}

	@Override
	public void onEnterAnimationComplete() {
		super.onEnterAnimationComplete();
		mTargetActivity.onEnterAnimationComplete();
	}

//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	@Override
	public ActionMode onWindowStartingActionMode(Callback callback) {
		return super.onWindowStartingActionMode(callback);
	}

	@Override
	public void onActionModeStarted(ActionMode mode) {
		super.onActionModeStarted(mode);
	}

	@Override
	public void onActionModeFinished(ActionMode mode) {
		super.onActionModeFinished(mode);
	}
		
	// tag_start:ListActivity
	// tag_end:ListActivity
	
	// tag_start:FragmentActivity
	// tag_end:FragmentActivity

	// tag_start:PreferenceActivity
	// tag_end:PreferenceActivity
	
	// tag_start:ExpandableListActivity
	// tag_end:ExpandableListActivity
		
//do NOT edit this file, auto-generated by host_target.groovy from StubBase_Activity.java.template
	// tag_start:ActionBarActivity
	// tag_end:ActionBarActivity
	
	
    // auxiliary function
	private void _log(String tag, String message) {
	   logD(tag, message);
	   if (LOG_stub) {
	       logD(tag, "mTargetActivity: " + mTargetActivity);
	   }
    }
    protected void logD(String tag, String message) {
	   android.util.Log.d(tag, message);
    }
}
