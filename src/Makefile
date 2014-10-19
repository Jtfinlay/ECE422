linux:
	javac *.java
	javah -classpath /cshome/jtfinlay/repos/ECE422/src InsertionSort
	gcc lib_insertionsort.c -I /usr/lib/jvm/default-java/include -I /usr/lib/jvm/default-java/include/linux -fpic -shared -o libinsertionsort.so

windows:
	javac *.java
	javah InsertionSort
	gcc lib_insertionsort.c -I "C:\Program Files (x86)\Java\jdk1.7.0_13\include" -I "C:\Program Files (x86)\Java\jdk1.7.0_13\include\win32" -fpic -shared -o libinsertionsort.so
