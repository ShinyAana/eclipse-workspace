package assignmentOnCollections;

import java.util.Objects;

public class StudentPojoArray 
{
	private int rollNo;
	private String studentName;
	private char std;
	private int tamilMark;
	private int englishMark;
	private int mathsMark;
	private int scienceMark;
	private int socialMark;
	private int totalMark;
	@Override
	public int hashCode() {
		return Objects.hash(englishMark, grade, mathsMark, rollNo, scienceMark, socialMark, std, studentName, tamilMark,
				totalMark);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPojoArray other = (StudentPojoArray) obj;
		return englishMark == other.englishMark && Objects.equals(grade, other.grade) && mathsMark == other.mathsMark
				&& rollNo == other.rollNo && scienceMark == other.scienceMark && socialMark == other.socialMark
				&& std == other.std && Objects.equals(studentName, other.studentName) && tamilMark == other.tamilMark
				&& totalMark == other.totalMark;
	}

	private String grade;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public char getStd() {
		return std;
	}
	public void setStd(char std) {
		this.std = std;
	}
	public int getTamilMark() {
		return tamilMark;
	}
	public void setTamilMark(int tamilMark) {
		this.tamilMark = tamilMark;
	}
	public int getEnglishMark() {
		return englishMark;
	}
	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}
	public int getMathsMark() {
		return mathsMark;
	}
	public void setMathsMark(int mathsMark) {
		this.mathsMark = mathsMark;
	}
	public int getScienceMark() {
		return scienceMark;
	}
	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}
	public int getSocialMark() {
		return socialMark;
	}
	public void setSocialMark(int socialMark) {
		this.socialMark = socialMark;
	}
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String toString()
	{
	    String output = "Student roll number " + getRollNo() + "\nName: " + getStudentName() + "\nClass : " + getStd() +
	        "\nTamil Mark: " + getTamilMark() + "\nEnglish Mark: " + getEnglishMark()+ "\nMaths Mark: " + getMathsMark() + "\nScience Mark: " + getScienceMark() + "\nSocial Mark: " + getSocialMark() + "\nTotal Mark: " + getTotalMark() + "\nGrade : " + getGrade();

	    return output;
	}


}
