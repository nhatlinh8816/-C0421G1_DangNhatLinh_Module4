package emailConfig.model.repository;

import emailConfig.model.bean.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigRepoImp implements EmailConfigRepo {
    EmailConfig emailConfig = new EmailConfig();
    @Override
    public EmailConfig displayConfig() {
        return emailConfig ;
    }

    @Override
    public EmailConfig update(EmailConfig editEmailConfig) {
        emailConfig.setLanguages(editEmailConfig.getLanguages());
        emailConfig.setPageSize(editEmailConfig.getPageSize());
        emailConfig.setSpamFilter(editEmailConfig.isSpamFilter());
        emailConfig.setSignature(editEmailConfig.getSignature());
        return emailConfig;
    }
}
