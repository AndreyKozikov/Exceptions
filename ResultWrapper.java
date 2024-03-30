package GeekBrains.Java.Exceptions;

import GeekBrains.Java.Exceptions.Exceptions.InvalidBirthDateException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidGenderException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidNamesException;
import GeekBrains.Java.Exceptions.Exceptions.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResultWrapper {
    private String[] result;
    private String input;

    public ResultWrapper(String input) {
        this.input = input;
    }

    public String[] getResult() throws InvalidPhoneNumberException, InvalidGenderException,
            InvalidBirthDateException, InvalidNamesException {
        this.result = this.parseInput(this.input);
        return result;
    }

    private String[] parseInput(String input) throws InvalidPhoneNumberException, InvalidGenderException,
            InvalidBirthDateException, InvalidNamesException {

        String[] data = input.split("\\s+");
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        long phoneNumber;
        char gender;
        try {
            phoneNumber = Long.parseLong(data[4]);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(birthDate); // проверка формата даты
        } catch (NumberFormatException e) {
            throw new InvalidPhoneNumberException();
        } catch (ParseException e) {
            throw new InvalidBirthDateException();
        }
        if (lastName.matches(".*\\d.*") || firstName.matches(".*\\d.*") || middleName.matches(".*\\d.*")) {
            throw new InvalidNamesException();
        }
        gender = data[5].charAt(0);
        if (gender != 'm' && gender != 'f') {
            throw new InvalidGenderException();
        }
        return new String[]{lastName, firstName, middleName, birthDate, String.valueOf(phoneNumber),
                String.valueOf(gender)};
    }
}