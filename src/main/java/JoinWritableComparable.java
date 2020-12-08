import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

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

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportID);
        dataOutput.writeInt(indicator);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airportID = dataInput.readInt();
        indicator = dataInput.readInt();
    }

    @Override
    public int compareTo(Object obj) {
        JoinWritableComparable other = (JoinWritableComparable)obj;
        if (this.airportID > other.airportID) return 1;
        if (this.airportID < other.airportID) return -1;
        if (this.indicator > other.indicator) return 1;
        if (this.indicator < other.indicator) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        JoinWritableComparable other = (JoinWritableComparable)obj;
        if (airportID != other.airportID) return false;
        return indicator == other.indicator;
    }

}
