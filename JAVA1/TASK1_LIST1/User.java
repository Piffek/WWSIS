package list1_z1;

import java.util.HashMap;
import java.util.Scanner;

public class User {
	private String whatParam, name, lastname, age;
	private HashMap<String, String> hashMap = new HashMap<String, String>();

	public HashMap ret() {
		return this.hashMap;
	}
	
	public String add(int a) {
	    Scanner getWhatParam = new Scanner(System.in);
	    whatParam = getWhatParam.nextLine();

	    if(a <= 3) {
		    switch(whatParam) {
		    case "-name":
			    	Scanner getName = new Scanner(System.in);
			        name = getName.nextLine();
			        this.hashMap.put("name", name);
			        System.out.println("Przyjęto dane");
			        return add(a+1);
		    case "-lastname":
			        Scanner getLastname = new Scanner(System.in);
			        lastname = getLastname.nextLine();
			        this.hashMap.put("lastname", lastname);
			        System.out.println("Przyjęto dane");
			        return add(a+1);
		    case "-age":
			        Scanner getAge = new Scanner(System.in);
			        age = getAge.nextLine();
			        this.hashMap.put("age", age);
			        System.out.println("Przyjęto dane");
			        return add(a+1);
			 default:
				 System.out.println("należy podać -name, -age albo -lastname");
				 return add(a+0);
		    }
	    }
	    return "";
	    
	}
}
