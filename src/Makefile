make:
	javac *.java
	javah -classpath /cshome/jtfinlay/repos/ECE422/src InsertionSort
	gcc lib_insertionsort.c -I /usr/lib/jvm/default-java/include -I /usr/lib/jvm/default-java/include/linux -fpic -shared -o libinsertionsort.so
