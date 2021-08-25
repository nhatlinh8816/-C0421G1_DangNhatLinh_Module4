package emailConfig.model.repository;

import emailConfig.model.bean.EmailConfig;

public interface EmailConfigRepo {
    EmailConfig displayConfig();
    EmailConfig update(EmailConfig editEmailConfig);
}
