package trainBooking;

import java.util.HashMap;
import java.util.List;

public class Train {
int trainId;
HashMap<String,List<Seats>> seatMap;
float totalfare;
public Train(int trainId, HashMap<String, List<Seats>> seatMap) {
	super();
	this.trainId = trainId;
	this.seatMap = seatMap;
}
public Train()
{
	
}
public int getTrainId() {
	return trainId;
}
public void setTrainId(int trainId) {
	this.trainId = trainId;
}
public HashMap<String, List<Seats>> getSeatMap() {
	return seatMap;
}
public void setSeatMap(HashMap<String, List<Seats>> seatMap) {
	this.seatMap = seatMap;
}
public float getTotalfare() {
	return totalfare;
}
public void setTotalfare(float totalfare) {
	this.totalfare = totalfare;
}

}
