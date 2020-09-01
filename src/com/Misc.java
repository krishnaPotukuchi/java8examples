package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Misc {

	public static void main(String[] args) {
		
		IntStream.range(1, 10).forEach(System.out::print);
		
		System.out.print(IntStream.range(1, 10).sum());
		
		System.out.print(IntStream.range(1, 10).max());
		
		Stream.of("Ashok","Amir","Asif").findFirst().ifPresent(System.out::print);
		
		String names[] = {"Ashok","Amir","Asif","Alok","Krishna","Suresh"};
		Arrays.stream(names).filter(i->i.startsWith("As")).sorted().forEach(System.out::print);
		
		Integer intArray[] = {4,2,9,6,3,8,1};
		Arrays.stream(intArray).map(x->x*x).collect(Collectors.toList()).forEach(System.out::print);

		List<String> people = Arrays.asList("Ashok","Amir","Asif","Alok","Krishna","Suresh");
		people.stream().map(i->i.toLowerCase()).filter(i->i.startsWith("k")).forEach(System.out::print);
		

	}
}
