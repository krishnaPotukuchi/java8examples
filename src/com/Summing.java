package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Summing {
	
	public static void main(String[] args) {
		StringBuffer sb = null;
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
		
		Double sumemp = emps.stream().map(i->i.salary).mapToDouble(Double::doubleValue).sum();
		Double sumemp2 = emps.stream().map(i->i.salary).reduce(0d, (a,b)->a+b);
		Double sumemp3 = emps.stream().map(i->i.salary).collect(Collectors.summingDouble(Double::doubleValue));
		
		System.out.println("Double sumemp   = "+sumemp);
		System.out.println("Double sumemp2  = "+sumemp2);
		System.out.println("Double sumemp3  = "+sumemp3);
		
		List<Double> integers = Arrays.asList(122.33d,167.22d, 223d, 356d, 4234d, 598.3d);
		Double sum = integers.stream().mapToDouble(Double::doubleValue).sum();
		Double sum1 = integers.stream().collect(Collectors.summingDouble(Double::doubleValue));
		Double sum2 = integers.stream().reduce(0d, (a,b)->a+b);
		System.out.println("Double sum  = "+sum);
		System.out.println("Double sum1 = "+sum1);
		System.out.println("Double sum2 = "+sum2);
	}

}

class Employee{
	public String name;
	public double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}