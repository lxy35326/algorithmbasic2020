#include <stdio.h>
#include "jni_Main.h"

JNIEXPORT void JNICALL Java_jni_Main_test
  (JNIEnv *env, jobject jobj){
    printf("hello");

    return;
  };