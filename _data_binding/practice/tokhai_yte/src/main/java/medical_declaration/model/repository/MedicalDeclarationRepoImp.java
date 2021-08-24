package medical_declaration.model.repository;

import medical_declaration.model.bean.MedicalDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalDeclarationRepoImp implements MedicalDeclarationRepo {
    MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
    @Override
    public MedicalDeclaration display() {
        return medicalDeclaration;
    }

    @Override
    public MedicalDeclaration edit(MedicalDeclaration editMedicalDeclaration) {
        medicalDeclaration.setName(editMedicalDeclaration.getName());
        medicalDeclaration.setDateOfBirth(editMedicalDeclaration.getDateOfBirth());
        medicalDeclaration.setCardId(editMedicalDeclaration.getCardId());
        medicalDeclaration.setTravelInformation(editMedicalDeclaration.getTravelInformation());
        medicalDeclaration.setTravelCity(editMedicalDeclaration.getTravelCity());
        medicalDeclaration.setAddress(editMedicalDeclaration.getAddress());
        medicalDeclaration.setHome(editMedicalDeclaration.getHome());
        medicalDeclaration.setSympathy(editMedicalDeclaration.getSympathy());
        medicalDeclaration.setExposure(editMedicalDeclaration.getExposure());
        return medicalDeclaration;
    }
}
