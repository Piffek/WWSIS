import java.util.Scanner;

public class Main {

	private static Scanner whichVehicle;
	private static Scanner yourName;

	public static void main(String [] args) {
		boolean exit = false;
		System.out.println("Aby korzystac z systemu podaj Swoje imie: ");
		
		Scanner yourName = new Scanner(System.in);
		String name = yourName.nextLine();
		
		Scanner whichVehicle = new Scanner(System.in);
		String which = whichVehicle.nextLine();

		switch(which){
			case "cars":
				Car car = new Car();
				car.programs(exit, car);
			case "bus":
				Bus bus = new Bus();
				bus.programs(exit, bus);
			case "motorcycle":
				Motorcycle motorcycle = new Motorcycle();
				motorcycle.programs(exit, motorcycle);
		}

	}
	
	
	public static Vehicle car(String which, String name) {
		Vehicle car = new Car();
		return car;
	}
	
	public static Vehicle bus(String which, String name) {
		Vehicle car = new Bus();
	    return car;
	}
	
	public static Vehicle motorcycle(String which, String name) {
		Vehicle car = new Motorcycle();
		return car;
	}
	
	
}
