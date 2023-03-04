package codegym.vn.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    @Override
    public double convert(double usd, double rate) {
        return usd * rate;
    }
}
