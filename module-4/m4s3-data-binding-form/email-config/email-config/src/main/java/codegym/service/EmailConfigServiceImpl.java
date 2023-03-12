package codegym.service;

import codegym.bean.EmailConfig;
import codegym.repository.EmailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigServiceImpl implements EmailConfigService{
    @Autowired
    private EmailConfigRepository emailConfigRepository;
    @Override
    public EmailConfig find() {
        return emailConfigRepository.find();
    }

    @Override
    public void update(EmailConfig emailConfig) {
        emailConfigRepository.update(emailConfig);
    }
}
