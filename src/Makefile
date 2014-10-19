make:
	javac *.java
	javah -classpath . InsertionSort
	gcc lib_insertionsort.c -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux -fpic -shared -o libinsertionsort.so
run:
	make
	java Driver
