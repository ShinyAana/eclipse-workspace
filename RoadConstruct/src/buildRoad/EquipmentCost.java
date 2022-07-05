package buildRoad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class EquipmentCost {

	public void equipmentDetails() {
		// TODO Auto-generated method stub
		boolean leftJustifiedRows = true;

		
		int maxWidth = 30;
		String[][] table = new String[][] { { "S.No", "Equipment", "Machine Hour", "Machine Rate", "Cost per hour" },
				{ "1", "Tractor", "0.5", "72.00", "36.00" },
				{ "2", "Loader", "1.0", "90.00", "90.00" },
				{ "3", "Crusher", "1.0", "90.00","90.00" },
				{ "4", "Stacker", "1.0", "15.00", "15.00"},
				{"5","Generator","1.0","20.00","20.00"} };

		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			boolean needExtraRow = false;
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}

		
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
					final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
					String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
					System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);

		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);

		
	}

	public void rockSpreadCost() {
		// TODO Auto-generated method stub
boolean leftJustifiedRows = true;

		
		int maxWidth = 30;
		String[][] table = new String[][] { { "S.No", "Activity", "Solid", "Prism", "Cost per Kilometer" },
				{ "1", "Develop pit", "0.10", "0.08", "74" },
				{ "2", "Drill and blast", "2.42", "1.83", "1833" },
				{ "3", "Crush", "2.90", "2.20","2197" },
				{ "4", "Load, transport, and spread", "4.03", "3.05", "3053"},
				{"5","Total cost per KM","9.45","7.16","7157"} };

		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			boolean needExtraRow = false;
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}

		
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
					final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
					String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
					System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);

		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);


		
		
	}

	public void drainageCost() {
		// TODO Auto-generated method stub
		
boolean leftJustifiedRows = true;

		
		int maxWidth = 30;
		String[][] table = new String[][] { { "S.No", "Equipment", "Machine Hour", "Machine Rate", "Cost per hour" },
				{ "1", "Backhoe", "6", "60.00", "36.00" },
				{ "2", "Truck", "9", "12.00", "90.00" },
				{ "3", "Pipe Cost", "", "","450.00" },
				{"4","Total Cost","","","918.00"}};

		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			boolean needExtraRow = false;
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}

		
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
					final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
					String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
					System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);

		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);


	}

	public void calculateManPower()
	{
boolean leftJustifiedRows = true;

		
		int maxWidth = 30;
		String[][] table = new String[][] { { "S.No", "Labour type", "Day", "Working Hour", "Cost per day" },
				{ "1", "Mason (1st class)", "1", "5", "350.00" },
				{ "2", "Mason (2st class)", "1", "7", "320.00" },
				{ "3", "Mazdoor (Unskilled)", "1", "7","280.00" },
				{ "4", "Mazdoor (Skilled)", "1", "5", "320.00"},
				{"5","Surveyor","1","3","500.00"},
				{"6","Mazdoor (Semi-skilled)","1","6","280.00"}};

		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			boolean needExtraRow = false;
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}

		
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
					final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
					String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
					System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);

		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);


	}

	public void printCost(int totalEquipmentCost, double totalRockSpreadCost, double totalDrainageCost,
			int totalManPowerCost)
	{
boolean leftJustifiedRows = true;

		
		int maxWidth = 30;
		String[][] table = new String[][] { { "S.No", "Type of Cost", "Unit", "Total cost", "Extra Charges" },
				{ "1", "Equipment Cost", "1 Hour", String.valueOf(totalEquipmentCost), "" },
				{ "2", "Rock Spread Cost", "KiloMeter", String.valueOf(totalRockSpreadCost), "" },
				{ "3", "Drainage Cost", "KiloMeter", String.valueOf(totalDrainageCost),"" },
				{ "4", "Man Power Cost", "1 Day", String.valueOf(totalManPowerCost), ""}};

		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			boolean needExtraRow = false;
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}

		
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
					final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
					String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
					System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);

		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);

	}
	
}
