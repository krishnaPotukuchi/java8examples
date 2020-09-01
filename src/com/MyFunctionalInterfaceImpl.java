package com;

import java.util.function.Predicate;

@FunctionalInterface
interface Interf{
	int m1(int a);
	
	default void d1() {
		System.out.println("MY default method");
	}
	
	default void d2() {
		System.out.println("MY default method 222222");
	}
	
	static void s1() {
		System.out.println("MY static method");
	}
	
	static void s2() {
		System.out.println("MY static method 2222222");
	}
	
	boolean equals(Object arg0);
}
public class MyFunctionalInterfaceImpl {

	public static void main(String[] args) {
		Predicate<Integer> p = i -> i>5;
		System.out.println("p="+ p.test(4));
		Interf i= a ->  a*a;
		i.m1(7);
		i.d1();
		i.d2();
		
		Interf.s1();
		Interf.s2();
		System.out.println(i.m1(17));
		
	}

}
