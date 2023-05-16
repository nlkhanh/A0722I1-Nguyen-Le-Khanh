package codegym.m4_case_study.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class StringToLocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return null;
    }
}
