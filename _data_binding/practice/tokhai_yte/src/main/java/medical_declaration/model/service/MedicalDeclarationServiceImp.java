package medical_declaration.model.service;

import medical_declaration.model.bean.MedicalDeclaration;
import medical_declaration.model.repository.MedicalDeclarationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalDeclarationServiceImp implements MedicalDeclarationService {
    @Autowired
    MedicalDeclarationRepo medicalDeclarationRepo;
    @Override
    public MedicalDeclaration display() {
        return medicalDeclarationRepo.display();
    }

    @Override
    public MedicalDeclaration edit(MedicalDeclaration editMedicalDeclaration) {
        return medicalDeclarationRepo.edit(editMedicalDeclaration);
    }
}
