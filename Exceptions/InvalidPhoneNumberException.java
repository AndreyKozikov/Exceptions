package GeekBrains.Java.Exceptions.Exceptions;

import java.util.Arrays;

public class InvalidPhoneNumberException extends NumberFormatException{
    public void getStackTrace(String s) {
        System.err.println(s + "\n" + Arrays.toString(super.getStackTrace()));
    }
}
