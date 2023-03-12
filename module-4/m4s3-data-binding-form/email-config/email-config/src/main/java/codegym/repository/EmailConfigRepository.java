package codegym.repository;

import codegym.bean.EmailConfig;

public interface EmailConfigRepository {
    EmailConfig find();
    void update(EmailConfig emailConfig);
}
