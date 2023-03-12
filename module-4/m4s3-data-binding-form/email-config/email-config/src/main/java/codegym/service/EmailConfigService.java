package codegym.service;

import codegym.bean.EmailConfig;

public interface EmailConfigService {
    EmailConfig find();
    void update(EmailConfig emailConfig);
}
