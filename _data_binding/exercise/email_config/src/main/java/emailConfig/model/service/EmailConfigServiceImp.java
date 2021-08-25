package emailConfig.model.service;

import emailConfig.model.bean.EmailConfig;
import emailConfig.model.repository.EmailConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigServiceImp implements EmailConfigService {
    @Autowired
    EmailConfigRepo emailConfigRepo;
    @Override
    public EmailConfig displayConfig() {
        return emailConfigRepo.displayConfig();
    }

    @Override
    public EmailConfig update(EmailConfig editEmailConfig) {
        return emailConfigRepo.update(editEmailConfig);
    }
}
