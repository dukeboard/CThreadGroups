#include <jni.h>
#include <syscall.h>

/*
 * Class:     org_kevoree_cthreadgroups_GetThreadID
 * Method:    getTid
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_kevoree_cthreadgroups_GetThreadID_getTid
    (JNIEnv *env, jobject obj) {
    jint tid = syscall(__NR_gettid);
    return tid;
}