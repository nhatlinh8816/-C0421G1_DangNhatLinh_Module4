package condiment.model.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class CondimentRepoImp implements CondimentRepo{


    @Override
    public ArrayList<String> showList() {
        return new ArrayList<>();
    }
}
