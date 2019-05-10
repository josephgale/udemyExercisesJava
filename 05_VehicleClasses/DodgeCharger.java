public class DodgeCharger extends Car {
    //attributes
    private String color;
    private String seats;

    //constructors
    public DodgeCharger(){
        this(3.6);
    }

    public DodgeCharger(double engineSize) {
        super(engineSize);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
