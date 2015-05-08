

/////lib/////
class Tag {
	String mName;
	Tag mSuper;
	Tag(String name, Tag superTag){
		mName=name;
                mSuper = superTag;
	}
}

activity = new Tag("Activity", null)
activityGroup = new Tag("ActivityGroup", activity)
accountAuthenticatorActivity = new Tag("AccountAuthenticatorActivity", activity)
aliasActivity = new Tag("AliasActivity", activity)
expandableListActivity = new Tag("ExpandableListActivity", activity)
fragmentActivity = new Tag("FragmentActivity", activity)
listActivity = new Tag("ListActivity", activity)
nativeActivity = new Tag("NativeActivity", activity)
tabActivity = new Tag("TabActivity", activity)
actionBarActivity = new Tag("ActionBarActivity", fragmentActivity)
launcherActivity = new Tag("LauncherActivity", listActivity)
preferenceActivity = new Tag("PreferenceActivity", listActivity)
tabActivity = new Tag("TabActivity", activityGroup)

service = new Tag("Service", null)
abstractInputMethodService = new Tag("AbstractInputMethodService", service)
accessibilityService = new Tag("AccessibilityService", service)
carrierMessagingService = new Tag("CarrierMessagingService", service)
dreamService = new Tag("DreamService", service)
hostApduService = new Tag("HostApduService", service)
intentService = new Tag("IntentService", service)
jobService = new Tag("JobService", service)
mediaBrowserService = new Tag("MediaBrowserService", service)
mediaRouteProviderService = new Tag("MediaRouteProviderService", service)
notificationCompatSideChannelService = new Tag("NotificationCompatSideChannelService", service)
notificationListenerService = new Tag("NotificationListenerService", service)
offHostApduService = new Tag("OffHostApduService", service)
printService = new Tag("PrintService", service)
recognitionService = new Tag("RecognitionService", service)
remoteViewsService = new Tag("RemoteViewsService", service)
settingInjectorService = new Tag("SettingInjectorService", service)
spellCheckerService = new Tag("SpellCheckerService", service)
textToSpeechService = new Tag("TextToSpeechService", service)
tvInputService = new Tag("TvInputService", service)
voiceInteractionService = new Tag("VoiceInteractionService", service)
voiceInteractionSessionService = new Tag("VoiceInteractionSessionService", service)
vpnService = new Tag("VpnService", service)
wallpaperService = new Tag("WallpaperService", service)
inputMethodService = new Tag("InputMethodService", wallpaperService)

broadcastReceiver = new Tag("BroadcastReceiver", null)
appWidgetProvider = new Tag("AppWidgetProvider", broadcastReceiver)
deviceAdminReceiver = new Tag("DeviceAdminReceiver", broadcastReceiver)
restrictionsReceiver = new Tag("RestrictionsReceiver", broadcastReceiver)
wakefulBroadcastReceiver = new Tag("WakefulBroadcastReceiver", broadcastReceiver)

ALL_TAGS=[
//activity 
activity,activityGroup,accountAuthenticatorActivity,aliasActivity,
expandableListActivity,tabActivity,fragmentActivity,listActivity,
nativeActivity,actionBarActivity,launcherActivity,preferenceActivity,
tabActivity,

//service
service,abstractInputMethodService,accessibilityService,carrierMessagingService,
dreamService,hostApduService,intentService,jobService,mediaBrowserService,
mediaRouteProviderService,notificationCompatSideChannelService,notificationListenerService,
offHostApduService,printService,recognitionService,remoteViewsService,
settingInjectorService,spellCheckerService,textToSpeechService,tvInputService,
voiceInteractionService,voiceInteractionSessionService,vpnService,wallpaperService,
inputMethodService,

// broadcastreceiver
broadcastReceiver,appWidgetProvider,deviceAdminReceiver,restrictionsReceiver,
wakefulBroadcastReceiver

]

def getTags(baseTagName) {
 	println "getTags: baseTagName:" + baseTagName
	def tag
	ALL_TAGS.each { if ("$it.mName" == baseTagName) {tag = it ; return;}}
	if (null == tag) return
 	println "tag: " + tag
	def List tags = new ArrayList();
	tags.add(tag);
	while (tag.mSuper != null) {
		tag = tag.mSuper
		tags.add(tag)
	}
	
    println('all tags for: ' + baseTagName)
	tags.each { println "tag: $it.mName"}
	
	return tags;
}


hostFile = new File("template/StubBase_Service.java.template")
targetFile = new File("template/Target_Service.java.template")
stubFile = new File("template/Stub_Service.java.template")

HOST_NOTE='//do NOT edit this file, auto-generated from ' + hostFile.name
TARGET_NOTE='//do NOT edit this file, auto-generated from ' + targetFile.name
STUB_NOTE='//do NOT edit this file, auto-generated from ' + stubFile.name
LOOP = 17

def genServiceFile(String dir, String superClassName) {
    genServiceFile(hostFile, new File(dir, "StubBase_" + superClassName + ".java"), superClassName, HOST_NOTE) 
    genServiceFile(stubFile, new File(dir, "Stub_" + superClassName + ".java"), superClassName, STUB_NOTE) 
    genServiceFile(targetFile, new File(dir, "Target_" + superClassName + ".java"), superClassName, TARGET_NOTE) 
}

def genServiceFile(File templateFile, File file, String superClassName, String note) {
    i = 0
    file.mkdirs()
    file.delete()
    REPLACE='SUPER_CLASS'

    println 'crated file: ' + file
    println 'superClassName: ' + superClassName 
    List<Tag> tags = getTags(superClassName);	
    allTags = new ArrayList<String>();
	println 'tags: ' + tags

    templateFile.eachLine {
        updateTag(allTags, it)
		if (shouldIgnore(allTags, tags, it)) {
		
		} else {
       		 if (it.contains(REPLACE)) {
            	it = it.replaceAll(REPLACE, superClassName)
        	} 		
		
			file.append(it)
        	file.append("\n")
	
        	i++
        	if (i % LOOP  == 0) {
           		file.append(note)
           		file.append "\n"
        	}
		}
 	}
}

def updateTag(ArrayList<String> tags, String it) {
	if (it.contains("tag_start:")) {
		it = it.substring(it.indexOf(":") + 1)
  		String[] tag = it.split(" ")
                for (String t : tag) {
			tags.add(t)
   		}
 		println 'tag_start:' + tag
	 	println 'tags: ' + tags
	}
	
	if (it.contains("tag_end:")) {
		it = it.substring(it.indexOf(":") + 1)
		String[] tag = it.split(" ")
                for (String t : tag ) {
			tags.remove(t)
		}
		println 'tag_end:' + tag		
	 	println 'tags: ' + tags
	}
}

def shouldIgnore(ArrayList<String> allTags, ArrayList<String> keepTags, String it){
	if (it.contains("tag_start:")) return false;
	if (allTags.size() == 0) return false;
	
	boolean hasOne = false;
	for (Tag i : keepTags) {
		for (String t : allTags ) {
 			if (i.mName.equals(t)){
 				hasOne = true;
			}
		}
	}
//	if (it.contains('tag_end:')) return true
     
    boolean ignore = hasOne ? false : true;
    
    println ""
    println "line    : " + it
    println "allTags : " + allTags
    println "keepTags: " + keepTags
    println "ignore  : " + ignore
    
    return ignore;
}

packagePath="org/bbs/apklauncher/api"	
note = "//do NOT edit this file, auto-generated."
def gen_plugin_library_service(String service){
	println "gen library for plugin developement." + " service: " + service
	
	templateActivityFile = new File("template/Library_Plugin_Service.java.template")
	File f = new File("export/plugin/" + packagePath + "/Base_" + service + ".java")
	f.mkdirs()
	f.delete()
	f.createNewFile()
	
    REPLACE='SUPER_CLASS'
        
    List<Tag> tags = getTags(service);	
    allTags = new ArrayList<String>();
    int i = 0;
    
    templateActivityFile.eachLine() {
    	//println it
    	updateTag(allTags, it)
		if (shouldIgnore(allTags, tags, it)) {
		
		}
		else
		{
    	
        	if (it.contains(REPLACE)) {
            	it = it.replaceAll(REPLACE, service)
        	}
                
        	f.append(it)
       	 	f.append("\n")
        }
        
        i++
        if (i % LOOP  == 0) {
           	f.append(note)
           	f.append "\n"
        }
    }
}

def gen_app_library_service(String service){
	println "gen library for app developement." + " service: " + service
	
	templateActivityFile = new File("template/Library_App_Service.java.template")
	File f = new File("export/app/" + packagePath + "/Base_" + service + ".java")
	f.mkdirs()
	f.delete()
	f.createNewFile()
	
    REPLACE='SUPER_CLASS'
    
    List<Tag> tags = getTags(service);	
    allTags = new ArrayList<String>();
    int i = 0;
    
    templateActivityFile.eachLine() {
    	//println it
    	updateTag(allTags, it)
		if (shouldIgnore(allTags, tags, it)) {
		
		}
		else
		{
    	
        	if (it.contains(REPLACE)) {
            	it = it.replaceAll(REPLACE, service)
        	}
                
        	f.append(it)
        	f.append("\n")
        }
        
        i++
        if (i % LOOP  == 0) {
           	f.append(note)
           	f.append "\n"
        }
    }
}

[
"Service", 
"IntentService"
].each() {
	println "gen stub sevice: $it"
	path="src/org/bbs/apklauncher/emb/auto_gen";
	
	genServiceFile(path, it)
	gen_plugin_library_service(it)
	gen_app_library_service(it)
}
