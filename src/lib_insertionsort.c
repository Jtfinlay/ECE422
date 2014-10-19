#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include "InsertionSort.h"

JNIEXPORT jintArray JNICALL Java_InsertionSort_insertsort
(JNIEnv *env, jobject object, jintArray values)
{
    jsize len;
    jint x, *arr;
    int i, j, mem;
    jboolean *is_copy;
    jintArray result;

    len = (*env)->GetArrayLength(env, values);
    arr = (jint *) (*env)->GetIntArrayElements(env, values, is_copy);
    mem += 9;
    if (arr == NULL)
    {
        printf("Cannot obtain array from JVM\n");
        exit(0);
    }
    mem+=1;

    for (i = 1; i < len; i++)
    {
        x = arr[i];
        j = i;
        while (j > 0 && arr[j-1] > x)
        {
            arr[j] = arr[j-1];
            j--;
            mem+=5;
        }
        arr[j] = x;
        mem+=16;
    }

    result = (*env)->NewIntArray(env, len+1);
    (*env)->SetIntArrayRegion(env, result, 0, len, arr);
    mem+=9;
    (*env)->SetIntArrayRegion(env, result, len, len+1, mem);

    return result;
}
