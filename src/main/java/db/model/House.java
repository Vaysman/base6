package db.model;

public class House implements Identifiable {
    private long number_house_id;
    private String adress;
    private long room_count;

    public long getId() {
        return number_house_id;
    }

    public void setId(long id) {
        this.number_house_id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getRoom_count() {
        return room_count;
    }

    public void setRoom_count(long room_count) {
        this.room_count = room_count;
    }


}