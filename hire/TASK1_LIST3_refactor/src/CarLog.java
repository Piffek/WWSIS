import java.time.LocalDateTime;

public class CarLog {
	String name;
    String number;
    LocalDateTime date;
    Color color;

    CarLog(String name, String number, LocalDateTime localDateTime, Color color)
    {
        this.name = name;
        this.number = number;
        this.date = localDateTime;
        this.color = color;
    } 
    
	
}
