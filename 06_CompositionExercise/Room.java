public class Room {
    private Phone phone;
    private Bed bed;
    private Lamp lamp;
    private Book book;
    private Fan fan;

    public Room(Phone phone, Bed bed, Lamp lamp, Book book, Fan fan) {
        this.phone = phone;
        this.bed = bed;
        this.lamp = lamp;
        this.book = book;
        this.fan = fan;
    }

    public void prepareRoom(){
        System.out.println("Setting phone to ringing.");
        phone.setRinging(true);
        System.out.println("Setting lamp to on.");
        lamp.setOn(true);
        System.out.println("Setting fan to on.");
        fan.powerOn();
        //setMade() already has println statement.
        bed.setMade(true);
    }

    public void getStatus(){
        phone.checkPhone();
        System.out.println("Bed made: " + bed.isMade());
        System.out.println("Book title: " + book.getTitle());
        System.out.println("Book genre: " + book.getGenre().getGenre());
        System.out.println("Lamp On: " + lamp.isOn());
        System.out.println("Fan On: " + fan.isOn());
    }

    public Phone getPhone() {
        return phone;
    }

    public Bed getBed() {
        return bed;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public Book getBook() {
        return book;
    }
}
