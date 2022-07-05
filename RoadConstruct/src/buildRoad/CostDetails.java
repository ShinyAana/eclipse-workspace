package buildRoad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CostDetails 
{
	String roadId;
	int regNo;
	int totalEquipmentCost;
	double totalRockSpreaadCost;
	double totalDrainageCost;
	int totalManPowerCost;
	double totalCost;
	boolean success;
	public CostDetails(String roadId,int regNo,int totalEquipmentCost,double totalRockSpreaadCost,double totalDrainageCost,int totalManPowerCost,double totalCost)
	{
		this.roadId=roadId;
		this.regNo=regNo;
		this.totalEquipmentCost=totalEquipmentCost;
		this.totalRockSpreaadCost=totalRockSpreaadCost;
		this.totalDrainageCost=totalDrainageCost;
		this.totalManPowerCost=totalManPowerCost;
		this.totalCost=totalCost;
	}
	public boolean addTodatabase()
	{
		try {
			Connection con=null;
			String sql="INSERT INTO CostDetails(RoadId,RoadRegisterNumber,EquipmentCost,RockSpreadCost,DrainageCost,ManPowerCost,TotalCost) VALUES(?,?,?,?,?,?,?)";
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
		    con.setAutoCommit(false);
			ps.setString(1,this.roadId);//create class
			ps.setInt(2,regNo);
			ps.setInt(3,this.totalEquipmentCost);
			ps.setDouble(4,this.totalRockSpreaadCost);
			ps.setDouble(5,this.totalDrainageCost);
			ps.setInt(6, this.totalManPowerCost);
			ps.setDouble(7,this.totalCost);
			success=ps.execute();
			con.commit();
			ps.close();
			con.close();
			} 
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return success;
		
	}
	
}
