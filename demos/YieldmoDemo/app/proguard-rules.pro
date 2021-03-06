# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/muthuka/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# For Google Ads
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# prevent proguard from removing generics from method signatures
-keepattributes Signature

-keep public class * extends android.app.IntentService

# keep sdk public classes and interfaces names
-keep public class com.yieldmo.sdk.YMPlacementView {
    public *;
}

-keep public class com.yieldmo.sdk.YMViewDelegate {
    public *;
}

-keep public class com.yieldmo.sdk.YMSdk {
    public *;
}

-keep public class com.yieldmo.sdk.YMConstants {
    public *;
}

-keep public class com.yieldmo.sdk.YMException {
    public *;
}

-keep public class com.yieldmo.sdk.view.YMConfigurationView {
    public *;
}

-keep public class com.yieldmo.sdk.view.YMConfigurationView$* {
    *;
}

-keep public class com.yieldmo.sdk.util.YMLogger {
    public *;
}

-keep public enum com.yieldmo.sdk.util.YMLogger$** {
    **[] $VALUES;
    public *;
}

-keepattributes **

# remove all internal sdk invocation to YMAssert
-assumenosideeffects class com.yieldmo.sdk.YMSdk {
   static *** YMAssert(...);
}

# reference: http://developer.android.com/google/play-services/setup.html

-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-dontwarn android.support.v7.**
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }