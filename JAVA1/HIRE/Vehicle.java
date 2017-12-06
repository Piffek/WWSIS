import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Vehicle {
	protected String name;
	protected String nr_registration;
	protected String kind;
	protected boolean is_rent = false;
	protected int rentPrice;
	protected String who;
	protected static String vehicle;
	protected int countAllCars = 0;
	protected int countRentCars = 0;
	protected int countNotRentCars = 0;
	ArrayList<CarLog> listRentHistory;
	LinkedList<Vehicle> vehicleList;
	
	public Vehicle() {
		this.name = name;
		this.nr_registration = nr_registration;
		this.kind = kind;
		this.is_rent = is_rent;
		this.rentPrice = rentPrice;
		this.listRentHistory = new ArrayList<CarLog>();
		this.vehicleList = new LinkedList();
		this.countAllCars = countAllCars;
		this.countNotRentCars = countNotRentCars;
		this.countRentCars = countRentCars;
	}
	

	public void add(int amount, Vehicle vehicle) {
		for(int i = 1; i <= amount; i++) {
			System.out.println("Nazwa:");
			Scanner name = new Scanner(System.in);
			String vehicleName = name.nextLine();
			
			System.out.println("Rejestracja:");
			Scanner registration = new Scanner(System.in);
			String vehicleRegistration = registration.nextLine();

			System.out.println("Cena wypozyczenia:");
			Scanner price = new Scanner(System.in);
			int rentPrice = price.nextInt();

			if(vehicle instanceof Car){
				Vehicle car = new Car();
				car.name = vehicleName;
				car.nr_registration = vehicleRegistration;
				car.rentPrice = rentPrice;
				car.kind = "car";
				this.vehicleList.add(car);
			}else if(vehicle instanceof Bus){
				Vehicle bus = new Bus();
				bus.name = vehicleName;
				bus.nr_registration = vehicleRegistration;
				bus.rentPrice = rentPrice;
				bus.kind = "bus";
				this.vehicleList.add(bus);
			}else{
				Motorcycle motor = new Motorcycle();
				motor.name = vehicleName;
				motor.nr_registration = vehicleRegistration;
				motor.rentPrice = rentPrice;
				motor.kind = "motorcycle";
				this.vehicleList.add(motor);
			}
			this.countAllCars++;
			this.countNotRentCars++;
		}
	}

	public void show(){
		for(int i = 0; i < this.vehicleList.size(); i++){
			System.out.println("----------------------------------");
			System.out.println("nazwa: "+this.vehicleList.get(i).name);
			System.out.println("rejestracja: "+this.vehicleList.get(i).nr_registration);
			System.out.println("Cena wypozyczenia: "+this.vehicleList.get(i).rentPrice+"zł");
			System.out.println("----------------------------------");
		}
	}

	
	public void delete(String registerNumber) {
		for (int i = 0; i < this.vehicleList.size(); i++){
			if(this.vehicleList.get(i).nr_registration.equals(registerNumber)){
				this.vehicleList.remove(i);
			}
		}
	}
	
	public void edit(String registerNumber) {
		for (int i = 0; i < this.vehicleList.size(); i++){
			if(this.vehicleList.get(i).nr_registration.equals(registerNumber)){

				System.out.println("Podaj nowa nazwe: ");
				Scanner nameOfVehicle = new Scanner(System.in);
				String newName = nameOfVehicle.nextLine();

				System.out.println("Podaj nowy numer rejestracyjny: ");
				Scanner numberRegistrationOfVehicle = new Scanner(System.in);
				String newRegistrationNumber = numberRegistrationOfVehicle.nextLine();

				System.out.println("Podaj nowa cene: ");
				Scanner priceOfVehicle = new Scanner(System.in);
				int newRentOfPrice = priceOfVehicle.nextInt();

				this.vehicleList.get(i).name = newName;
				this.vehicleList.get(i).nr_registration= newRegistrationNumber;
				this.vehicleList.get(i).rentPrice = newRentOfPrice;
			}
		}
	}
	
	public void rent(String registerNumber) {
		for (int i = 0; i < this.vehicleList.size(); i++){
			if(this.vehicleList.get(i).nr_registration.equals(registerNumber)){
				if(this.vehicleList.get(i).is_rent == true){
					System.out.println("Ten samochod jest wypozyczony");
				}else {
					this.vehicleList.get(i).is_rent = true;
					CarLog log = new CarLog(
							this.vehicleList.get(i).name,
							this.vehicleList.get(i).nr_registration,
							LocalDateTime.now()
					);
					this.listRentHistory.add(log);
					this.countRentCars++;
					this.countNotRentCars--;
				}
			}
		}
	}
	
	public void diversion(String registerNumber) {
		for (int i = 0; i < this.vehicleList.size(); i++) {
			if (this.vehicleList.get(i).nr_registration.equals(registerNumber)) {
				this.vehicleList.get(i).is_rent = false;
				this.countNotRentCars++;
				this.countRentCars--;
			}
		}
		System.out.println("Oddano");
	}

	
	public void caniRent(String nr_registration) {
		for (int i = 0; i < this.vehicleList.size(); i++) {
			if (this.vehicleList.get(i).nr_registration.equals(nr_registration)) {
				if(this.vehicleList.get(i).is_rent = true) {
					System.out.println("Samochod jest wypozyczony");
				}else {
					System.out.println("Samochod mozna wypozyczyc");
				}
			}
		}
	}
	
	public int getCountAllCars() {
		return this.countAllCars;
	}
	
	public int getCountRentCars() {
		return this.countRentCars;
	}

	public int getCountNotRentCars() {
		return this.countNotRentCars;
	}
	
	public void programs(boolean exit, Vehicle car) {
			while(exit == false) {
				print("------Witaj-----");
				print("1.Dodaj");
				print("2.Usun");
				print("3.Edytuj dane");
				print("4.Czy moga wypozyczyc?");
				print("5.Wypozycz");
				print("6.Zwroc");
				print("7.Pokaz wszystkie");
				print("8.Historia wypozyczen");
				print("9.Pokaz statystyki");
				Scanner what = new Scanner(System.in);
				String doing = what.nextLine();
		
			switch(doing) {
				case "1" :
					System.out.println("Ile dodac?");
					Scanner amount = new Scanner(System.in);
					int amountCars = amount.nextInt();
					car.add(amountCars, car);
					break;
				case "2":
					System.out.println("Ktory chcesz usunac? Podaj numer rejestracyjny");
					Scanner number = new Scanner(System.in);
					String numberCars = number.nextLine();
					car.delete(numberCars);
					continue;
				case "3":
					System.out.println("Ktory edytowac?");
					Scanner num = new Scanner(System.in);
					String numOfCars = num.nextLine();
					car.edit(numOfCars);
					continue;
				case "4":
					System.out.println("Podaj numer rejestracyjny");
					Scanner numberRentCar = new Scanner(System.in);
					String nr_reg = numberRentCar.nextLine();
					car.caniRent(nr_reg);
					continue;
				case "5":
					System.out.println("Ktory wypozyczyc?");
					Scanner numberCarToRent = new Scanner(System.in);
					String whatRent = numberCarToRent.nextLine();
					car.rent(whatRent);
					continue;
				case "6":
					System.out.println("Ktory oddac?");
					Scanner numberCarToDiversion = new Scanner(System.in);
					String whatDiversion = numberCarToDiversion.nextLine();
					car.diversion(whatDiversion);
					continue;
				case "7":
					car.show();
					continue;
				case "8":
					showLog(car);
					continue;
				case "9":
					System.out.println("Wszystkich samochodow:" + car.getCountAllCars());
					System.out.println("Wypozyczonych samochodow: " + car.getCountRentCars());
					System.out.println("Wolnych samochodow: " + car.getCountNotRentCars());
					continue;
				case "10":
					exit = true;
				}
			}		
	}
	
	public void showLog(Vehicle car) {
		System.out.println("1.Historia calej wypozyczalni");
		System.out.println("2.Historia jednego pojazdy");
		Scanner logCars = new Scanner(System.in);
		String logs = logCars.nextLine();
		switch(logs) {
	        case "1":
	        	System.out.println("Wypozyczenia: ");
	        	for(int i = 0; i < this.listRentHistory.size(); i++) {
					System.out.println("Nazwa: " + this.listRentHistory.get(i).name);
					System.out.println("Numer rejestracyjny: " + this.listRentHistory.get(i).number);
					System.out.println("Data: " + this.listRentHistory.get(i).date);
				}

			case "2":
				System.out.println("Podaj Numer rejestracyjny samochodu: ");
				Scanner nr_reg = new Scanner(System.in);
				String nr_registration = nr_reg.nextLine();
				for(int i = 0; i < this.listRentHistory.size(); i++) {
					if(this.listRentHistory.get(i).number.equals(nr_registration)){
						System.out.println("Nazwa: " + this.listRentHistory.get(i).name);
						System.out.println("Numer rejestracyjny: " + this.listRentHistory.get(i).number);
						System.out.println("Data: " + this.listRentHistory.get(i).date);
					}
				}
		}
	}

	public void print(String name){
		System.out.println(name);
	}

	
}
