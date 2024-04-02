//gets the bound and says that its not there

public class IntOutOfRangeException extends Exception {

    public IntOutOfRangeException (int Bound) {super("The input value exceeds the bound " + Bound);} } 