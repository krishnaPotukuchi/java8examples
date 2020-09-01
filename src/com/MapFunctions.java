package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class MapFunctions {

	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<>();
		hm.put("a", "1");
		hm.put("d", "4");
		hm.put("b", "2");
		hm.put("e", "5");
		hm.put("c", "0");
		
		Map<String, String> hm1 = (Map<String, String>) hm.entrySet().stream().
				sorted(Entry.comparingByValue()).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2)->e2,LinkedHashMap::new));
		
		System.out.println(hm1);
		
		List<String> people = Arrays.asList("Ashok","Amir","Asif","Alok","Krishna","Suresh");
		String result = people.stream().map(i->i.toLowerCase()).filter(i->i.startsWith("a")).collect(Collectors.joining(","));
		System.out.println(result);
		
		String names[] = {"Ashok","Amir","Asif","Alok","Krishna","Suresh"};
		Arrays.stream(names).map(i->i.toLowerCase()).filter(i->i.startsWith("k")).collect(Collectors.toList()).forEach(System.out::println);
		
		Employee e1 = new Employee("Krishna", 322.3d);
		Employee e2 = new Employee("Kiran", 276.5d);
		Employee e3 = new Employee("Ramu", 343.6d);
		Employee e4 = new Employee("Arjun", 783.8d);
		Employee e5 = new Employee("Shyam", 474.5d);
		List<Employee> emps = new ArrayList<>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		
		Double sum = emps.stream().map(i->i.salary).mapToDouble(Double::doubleValue).sum();
		System.out.println("sum = "+sum);
		
		Double sum1 = emps.stream().map(i->i.salary).reduce(0d, Double::sum);
		System.out.println("sum1= "+sum1);
		
		Double sum2= emps.stream().map(i->i.salary).collect(Collectors.summingDouble(Double::doubleValue));
		System.out.println("sum2= "+sum2);
		
		Double sum3= emps.stream().map(i->i.salary).collect(Collectors.averagingDouble(Double::doubleValue));
		System.out.println("sum3= "+sum3);
		
		long count = emps.stream().map(i->i.name.toUpperCase()).filter(i->i.startsWith("A")).count();
		System.out.println("Count="+count);
		
		 Map<String, List<Integer>> map  = new HashMap<>();
		 List<Integer> l1 = Arrays.asList(1,3,5,7,8);
		 List<Integer> l2 = Arrays.asList(33,43,65,57,78);
		 map.put("a", l1);
		 map.put("b", l2);
		 System.out.println(map);		 
		 
		 Map<String, Integer> map1 = map.entrySet().stream().collect(Collectors.toMap(Entry::getKey, i->i.getValue().stream().mapToInt(Integer::intValue).sum()));
		 System.out.println(map1);
		 
		 Integer sumTotal = map1.entrySet().stream().map(i->i.getValue()).mapToInt(Integer::intValue).sum();
		 Integer sumTotal1 = map1.entrySet().stream().map(i->i.getValue()).reduce(0, Integer::sum);
		 System.out.println(sumTotal);
		
		 System.out.println(sumTotal1);
	}

}
