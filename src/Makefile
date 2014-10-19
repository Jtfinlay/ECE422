make:
	javac *.java
	javah -classpath . InsertionSort
	gcc lib_insertionsort.c -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux -fpic -shared -o libinsertionsort.so
run:
	java Generator in.txt 10
	java Driver in.txt out.txt 1 1 3
