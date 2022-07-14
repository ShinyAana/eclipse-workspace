package interview;
class StringRotation2
{
    // Function to check if `X` can be derived from `Y` by rotating it
    public static boolean check(String X, String Y)
    {
        // base case
        if (X == null || Y == null) {
            return false;
        }
 
        // if string lengths are different, they can't be
        // derived from each other
        if (X.length() != Y.length()) {
            return false;
        }
 
        // Invariant: At the i'th iteration of this loop,
        // the string `X` will be rotated by `i` units
        for (int i = 0; i < X.length(); i++)
        {
            // left rotate string `X` by 1 unit
            X = X.substring(1) + X.charAt(0);
 
            // return true if `X` becomes equal to `Y`
            if (X.compareTo(Y) == 0) {
                return true;
            }
        }
 
        // return false if no rotation is matched
        return false;
    }
 
    public static void main(String[] args)
    {
        String X = "AMAZON";
        String Y = "AZONAM";
 
        if (check(X, Y)) {
            System.out.println("Given strings can be derived from each other");
        }
        else {
            System.out.println("Given strings cannot be derived from each other");
        }
    }
}

