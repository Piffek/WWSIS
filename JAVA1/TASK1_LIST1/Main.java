package list1_z1;

public class Main {
	public static void main(String[] args){
	    User addParam = new User();
	    addParam.add(1); 
	    hello(addParam);
	}
	
	public static void hello(User param) {
		System.out.println(" Witaj "+param.ret().get("name")+" "+param.ret().get("lastname")+". Twój wiek to "+param.ret().get("age"));
	}
}
