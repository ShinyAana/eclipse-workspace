package assignmentOnCollections;

import java.util.Comparator;

public class rollNoComparator implements Comparator<StudentPojoArray> {


	@Override
	public int compare(StudentPojoArray o1, StudentPojoArray o2) {
		// TODO Auto-generated method stub
		return o1.getStudentName().compareTo(o2.getStudentName());
	}

}
