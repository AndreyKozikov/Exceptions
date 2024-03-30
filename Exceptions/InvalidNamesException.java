package GeekBrains.Java.Exceptions.Exceptions;

import java.util.Arrays;

public class InvalidNamesException extends Exception {
    public void getStackTrace(String s) {
        System.err.println(s + "\n" + Arrays.toString(super.getStackTrace()));
    }
}
