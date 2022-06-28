package lesson06;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator; 


public class Code01_Comparator {
	
	public static class Student{
		public String name;
		public int id;
		public int age;
		
		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}
	
	// 比较器的思想： 只要知道如何比大小，比较器就可以调用内部统一的策略进行排序
	// 任何比较：
	// compare方法里，遵循一个同一的思想：
	// 返回负数的时候，认为第一个参数应该排在前面
	// 返回正数的时候，认为第二个参数应该排在前面
	// 返回0的时候，认为无所谓谁放在前面
	// 系统的排序的时间复杂度是O(N * log(N));
	
	// 根据id从小到大，但是如果id一样，按照年龄从小到大 
	public static class IdUpAgeDownOrder implements Comparator<Student>{
		
		public int compare (Student s1, Student s2) {
			return s1.id != s2.id ? s1.id - s2.id : s2.age - s1.age;
		}
	}
	
	// 根据id从小到大排
	public static class idUpComparator implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.id - s2.id;
		}
	}
	
	// 根据id从大到小排
	public static class idDownComparator implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s2.id - s1.id;
		}
	}
	
	// for test
	public static void main(String[] args) {

		Student s1 = new Student("A", 1, 11);
		Student s2 = new Student("B", 2, 12);
		Student s3 = new Student("C", 3, 14);
		Student s4 = new Student("D", 6, 115);
		Student s5 = new Student("E", 4, 131);
		Student s6 = new Student("F", 4, 1111);
		
	//  数组排序
	    Student[] students = new Student[] {s1, s2, s3, s4, s5, s6};	
    //	Arrays.sort(students, new idDownComparator());
    //  Arrays.sort(students, new idUpComparator());
        Arrays.sort(students, new IdUpAgeDownOrder());
	//  System.out.println("ArraysSort IdUp");
	    for(int i = 0; i < students.length; i++)
	    {
	//		System.out.println(students[i].name);
	    }
	  
	//  链表排序
	    ArrayList<Student> studentList = new ArrayList<>();
	    studentList.add(s1);
	    studentList.add(s2);
	    studentList.add(s3);
	    studentList.add(s4);
	    studentList.add(s5);
	    studentList.add(s6);
	    
    //  studentList.sort(new idDownComparator());
    //  studentList.sort(new idUpComparator());
    //  studentList.sort(new IdUpAgeDownOrder());
        
        for(int i = 0; i < studentList.size(); i++) {
        	Student s =  studentList.get(i);
        	System.out.println(s.name);
        }
       
        
    // 有序表排序
    // 比较器里没有相同的Key，在这里也就是没有相同的对象。当放进去相同的key进去，有序表不会覆盖掉旧的，但是hashmap
    // 会。根据对象的某一属性进行比较 
       System.out.println("treemap sort"); 
    // TreeMap<Student, String>treeMap = new TreeMap<>(new idDownComparator()); 
    // TreeMap<Student, String>treeMap = new TreeMap<>((a, b) -> a.id - b.id);
       TreeMap<Student, String>treeMap = new TreeMap<>((a, b) -> a.id != b.id ? (a.id - b.id) : (b.hashCode() - a.hashCode()));  
       treeMap.put(s1, "A");
       treeMap.put(s2, "B");
       treeMap.put(s3, "C");
       treeMap.put(s4, "D");
       treeMap.put(s5, "E");
       treeMap.put(s6, "F");
       
       for(Student s : treeMap.keySet()) {
    	   System.out.println(s.name);
       }
	}

}

