package case_study_module4.furama_resort_manager.model.entity.employee;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingCryptPass {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }
}
