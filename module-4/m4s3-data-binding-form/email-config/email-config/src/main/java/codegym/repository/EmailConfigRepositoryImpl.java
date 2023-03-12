package codegym.repository;

import codegym.bean.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigRepositoryImpl implements EmailConfigRepository{
    private static EmailConfig currentConfig = new EmailConfig();

    @Override
    public EmailConfig find() {
        return currentConfig;
    }

    @Override
    public void update(EmailConfig emailConfig) {
        currentConfig = emailConfig;
    }
}
