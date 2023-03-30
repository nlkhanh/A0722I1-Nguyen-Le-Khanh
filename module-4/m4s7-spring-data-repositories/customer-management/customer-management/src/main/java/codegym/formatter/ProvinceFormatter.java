package codegym.formatter;

import codegym.model.Province;
import codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements Formatter<Province> {
    private ProvinceService provinceService;

    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String id, Locale locale) throws ParseException {
        return provinceService.findById(Long.parseLong(id));
    }

    @Override
    public String print(Province province, Locale locale) {
        return "[" + province.getProvinceId() + ", " + province.getName() + "]";
    }
}
