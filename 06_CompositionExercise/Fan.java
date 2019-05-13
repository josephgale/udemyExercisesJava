public class Fan {
    private boolean isOn = false;

    public Fan(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void hitPower(){
        if(isOn==true){
            isOn=false;
        }
        if(isOn==false){
            isOn=true;
        }
    }

    public void powerOn(){
        isOn=true;
    }
}
