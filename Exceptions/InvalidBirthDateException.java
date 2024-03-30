package GeekBrains.Java.Exceptions.Exceptions;

import java.util.Arrays;

public class InvalidBirthDateException extends Exception {
    public void getStackTrace(String s) {
        System.err.println(s + "\n" + Arrays.toString(super.getStackTrace()));
    }

}
