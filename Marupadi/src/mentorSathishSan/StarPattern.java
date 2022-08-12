package mentorSathishSan;

	  public class StarPattern {

	public static void main(String[] args) 
	{
		  // set a size
	    int size = 5;
	    // upper pyramid
	    for (int i = 1; i <= size; i++) {
	      // print spaces
	      for (int j = size; j > i; j--) {
	        System.out.print(" ");
	      }
	      // print star
	      for (int k = 0; k < i * 2 - 1; k++) {
	        System.out.print("*");
	      }
	      System.out.println();
	    }
	    // lower pyramid
	    for (int i = 1; i <= size - 1; i++) {
	      // print spaces
	      for (int j = 0; j < i; j++) {
	        System.out.print(" ");
	      }
	      // print star
	      for (int k = (size - i) * 2 - 1; k > 0; k--) {
	        System.out.print("*");
	      }
	      System.out.println();
	    }
	  }
	}


