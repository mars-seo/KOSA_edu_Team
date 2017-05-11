package team1.Homvis.elecNgas;

public class Light {
    private String room;
    private boolean onOff;

    public Light(String room, boolean onOff) {
        this.room = room;
        this.onOff = onOff;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    
}
