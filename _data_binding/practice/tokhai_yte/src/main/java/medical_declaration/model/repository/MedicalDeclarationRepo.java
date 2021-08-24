package medical_declaration.model.repository;

import medical_declaration.model.bean.MedicalDeclaration;

public interface MedicalDeclarationRepo {
    MedicalDeclaration display();
    MedicalDeclaration edit(MedicalDeclaration editMedicalDeclaration);

}
