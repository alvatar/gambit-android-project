#include <jni.h>

#ifndef _Included_org_schemespheres_fusion_MainActivity
#define _Included_org_schemespheres_fusion_MainActivity
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jstring JNICALL Java_org_schemespheres_fusion_GambitRunnable_testFib(JNIEnv *, jobject);

JNIEXPORT jstring JNICALL Java_org_schemespheres_fusion_GambitRunnable_testPorts(JNIEnv *, jobject);

JNIEXPORT void JNICALL Java_org_schemespheres_fusion_GambitRunnable_initGambit(JNIEnv *, jobject);

JNIEXPORT void JNICALL Java_org_schemespheres_fusion_GambitRunnable_schemeMain(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
