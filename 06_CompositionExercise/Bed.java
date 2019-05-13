public class Bed {
    private boolean isMade;

    public Bed() {
        this.isMade = false;
    }

    public boolean isMade() {
        return isMade;
    }

    public void setMade(boolean made) {
        if(made){
            System.out.println("Making the bed");
        }
        isMade = made;
    }
}
