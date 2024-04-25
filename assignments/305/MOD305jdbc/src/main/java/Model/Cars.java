package Model;

public class Cars {

    private String parkingSpot;
    private String makeModel;
    private int id;
    private int garageId;

    public Cars(){};
    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }
}
