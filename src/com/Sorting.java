package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Sorting {
	
	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<>();
		hm.put("a", "1");
		hm.put("d", "4");
		hm.put("b", "2");
		hm.put("e", "5");
		hm.put("c", "0");

		Map<String, String> sorted = hm.entrySet().stream().sorted(Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2)->e2, LinkedHashMap::new));
	
		System.out.println(sorted);
		
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<String, String>>() {
			public int compare(Entry<String, String> m1, Entry<String, String> m2) {
				return m2.getValue().compareTo(m1.getValue());
			}
		  }
		);
		
		System.out.println(list);
		
		List<Emp> elist = new ArrayList<>();
		elist.add(new Emp(2,"Krishna","Potukuchi"));
		elist.add(new Emp(1,"Sridhar","Nuti"));
		elist.add(new Emp(4,"Kiran","Damarapally"));
		elist.add(new Emp(5,"Mohan","Pulicherla"));
		elist.add(new Emp(3,"Mahadev","Neelam"));
		
		Comparator<Emp> compareByFullName = Comparator.comparing(Emp::getFirstName)
				 									  .thenComparing(Emp::getLastName);
		
		Collections.sort(elist, compareByFullName);
		elist.stream().forEach(System.out::println);
		
	}

}

class Emp{
	private int id;
	private String firstName;
	private String lastName;
	
	public Emp(int id, String fname, String lname) {
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return  "Id="+this.id+", First Name="+this.firstName+", Last Name="+this.lastName;
	}
}
