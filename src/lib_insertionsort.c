#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include "InsertionSort.h"

JNIEXPORT jintArray JNICALL Java_InsertionSort_sort
(JNIEnv *env, jobject object, jintArray values)
{
    jsize len;
    jint x, *arr;
    int i, j;
    jboolean *is_copy;
    jintArray result;

    len = (*env)->GetArrayLength(env, values);
    arr = (jint *) (*env)->GetIntArrayElements(env, values, is_copy);
    if (arr == NULL)
    {
        printf("Cannot obtain array from JVM\n");
        exit(0);
    }

    for (i = 1; i < len; i++)
    {
        x = arr[i];
        j = i;
        while (j > 0 && arr[j-1] > x)
        {
            arr[j] = arr[j-1];
            j--;
        }
        arr[j] = x;
    }

    result = (*env)->NewIntArray(env, len);
    (*env)->SetIntArrayRegion(env, result, 0, len, arr);

    return result;
}
