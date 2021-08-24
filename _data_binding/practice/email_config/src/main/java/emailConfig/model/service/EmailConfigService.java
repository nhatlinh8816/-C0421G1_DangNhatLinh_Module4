package emailConfig.model.service;

import emailConfig.model.bean.EmailConfig;

public interface EmailConfigService {
    EmailConfig displayConfig();
    EmailConfig update(EmailConfig editEmailConfig);
}
