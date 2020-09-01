package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByPartitioningBy {
	
	public static void main(String[] args) {
		
		Dept d1 = new Dept(10, "Technical", "active");
		Dept d2 = new Dept(20, "Admin", "active");
		Dept d3 = new Dept(10, "Technical", "inactive");
		List<Dept> list = new ArrayList<Dept>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		
		Map<Boolean, List<Dept>> map = list.stream().collect(Collectors.partitioningBy(i->i.getDeptId()==10));
		System.out.println(map);
		
		Map<String, List<Dept>> map1 = list.stream().collect(Collectors.groupingBy(i->i.getDname()));
		System.out.println(map1);
		
		Map<Integer, List<Dept>> map2 = list.stream().collect(Collectors.groupingBy(i->i.getDeptId()));
		System.out.println(map2);
	}

}

class Dept{
	
	private int deptId;
	private String dname;
	private String status;
	
	public Dept(int deptId, String dname, String status) {
		this.deptId = deptId;
		this.dname = dname;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Override
	public String toString() {
		return "Dept Id="+this.deptId+", Dept Name="+this.dname+", Status="+this.status;
	}
	
}