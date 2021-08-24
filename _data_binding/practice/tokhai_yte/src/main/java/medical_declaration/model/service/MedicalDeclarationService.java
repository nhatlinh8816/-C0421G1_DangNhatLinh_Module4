package medical_declaration.model.service;

import medical_declaration.model.bean.MedicalDeclaration;

public interface MedicalDeclarationService {
    MedicalDeclaration display();
    MedicalDeclaration edit(MedicalDeclaration editMedicalDeclaration);
}
