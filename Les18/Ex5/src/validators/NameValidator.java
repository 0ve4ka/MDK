package validators;

import exceptions.ValidateException;
import exceptions.ValidateNameException;

public class NameValidator implements Validator{
    @Override
    public void validate(String value) throws ValidateException {
        if(value == null)
            throw new ValidateNameException("Имя не должно быть пустым!");
    }
}
