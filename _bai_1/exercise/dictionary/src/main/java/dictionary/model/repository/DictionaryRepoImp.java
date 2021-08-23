package dictionary.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepoImp implements DictionaryRepo {
    @Override
    public String translate(String vietnamese) {
         Map<String,String> dictionaryMap = new HashMap<>();
            dictionaryMap.put("Hoa","Flower");
            dictionaryMap.put("Sen","Lotus");
            dictionaryMap.put("Tay","Hand");
            dictionaryMap.put("Máy tính","Computer");
            dictionaryMap.put("Ba","Father");
            String english = dictionaryMap.get(vietnamese);

        return english;
    }
}
