public class Contact {
    private String name;
    private long number;

    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    public void changeName(String newName){
        name = newName;
    }

    public void changeNumber(Long newNumber){
        number = newNumber;
    }


}
