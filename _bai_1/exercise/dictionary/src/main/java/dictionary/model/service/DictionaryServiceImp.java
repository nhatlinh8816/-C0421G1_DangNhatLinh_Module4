package dictionary.model.service;

import dictionary.model.repository.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceImp implements DictionaryService {
    @Autowired
    DictionaryRepo dictionaryRepo;
//    static Map<String,String> dictionaryMap = new HashMap<>();
//    static {
//        dictionaryMap.put("Hoa","Flower");
//        dictionaryMap.put("Sen","Lotus");
//        dictionaryMap.put("Tay","Hand");
//        dictionaryMap.put("Máy tính","Computer");
//        dictionaryMap.put("Ba","Father");
//    }
    @Override
    public String translate(String vietnamese) {
        return dictionaryRepo.translate(vietnamese);
    }
}
