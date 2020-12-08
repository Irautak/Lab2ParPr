public class JoinWritableComparable {
    private int airportID;
    private int indicator;

    public JoinWritableComparable() {}

    public JoinWritableComparable(int airportID, int indicator) {
        this.airportID = airportID;
        this.indicator = indicator;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getAirportID() {
        return airportID;
    }

    public int getIndicator() {
        return indicator;
    }

    
}
