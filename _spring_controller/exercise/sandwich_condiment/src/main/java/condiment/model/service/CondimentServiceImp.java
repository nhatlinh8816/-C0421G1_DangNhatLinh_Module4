package condiment.model.service;

import condiment.model.repository.CondimentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentServiceImp implements CondimentService {
    @Autowired
    CondimentRepo condimentRepo;


    @Override
    public ArrayList<String> showList() {
        return condimentRepo.showList();
    }
}

