package codegym.library.custom_validate;

import codegym.library.entity.BorrowCard;
import codegym.library.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class BorrowCardValidate implements Validator {
    @Autowired
    private BorrowCardService borrowCardService;

    @Override
    public boolean supports(Class<?> clazz) {
        return BorrowCard.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowCard borrowCard = new BorrowCard();
        if (target instanceof BorrowCard) {
            borrowCard = (BorrowCard) target;
        }

        String id = borrowCard.getId();
        LocalDate borrowDate = borrowCard.getBorrowDate();
        LocalDate returnDate = borrowCard.getReturnDate();

        if (!id.matches("MS-[0-9]{4}")) {
            errors.rejectValue("id", "regex.borrowCardId");
        } else if (borrowCardService.existsById(id)) {
            errors.rejectValue("id", "exist.borrowCardId");
        } else if (returnDate == null) {
            errors.rejectValue("returnDate", "empty.returnDate");
        } else {
            int dateDiffCompare = returnDate.compareTo(borrowDate);
            if (dateDiffCompare < 0) {
                errors.rejectValue("returnDate", "dateDiff.returnDate");
            }
        }
    }
}
