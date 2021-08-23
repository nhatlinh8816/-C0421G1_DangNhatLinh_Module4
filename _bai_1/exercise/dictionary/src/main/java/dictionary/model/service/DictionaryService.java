package dictionary.model.service;

import java.util.HashMap;
import java.util.Map;

public interface DictionaryService {
//    static Map<String,String> dictionaryMap = new HashMap<>();
//    static {
//        dictionaryMap.put("Hoa","Flower");
//        dictionaryMap.put("Sen","Lotus");
//        dictionaryMap.put("Tay","Hand");
//        dictionaryMap.put("Máy tính","Computer");
//        dictionaryMap.put("Ba","Father");
//    }
    String translate(String vietnamese);
}
