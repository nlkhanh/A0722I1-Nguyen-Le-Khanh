package codegym.validation;

import codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = new User();
        if (object instanceof User) {
            user = (User) object;
        }
        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "empty.phone");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "length.phone");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "startsWith.phone");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "matches.phone");
        }
    }
}
