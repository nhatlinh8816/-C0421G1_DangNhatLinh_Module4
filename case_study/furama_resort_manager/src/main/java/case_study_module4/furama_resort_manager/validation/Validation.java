package case_study_module4.furama_resort_manager.validation;

public class Validation {
    public static final String CUSTOMER_CODE_REGEX = "^(KH-)[0-9]{4}$";
    public static final String SERVICE_CODE_REGEX = "^(DV-)[0-9]{4}$";
    public static final String PHONE_NUMBER_REGEX = "^((\\(84\\)\\+(90))|(090)|(091)|(\\(84\\)\\+(91)))[\\d]{7}$";
    public static final String IDENTITY_CARD_REGEX ="^[\\d]{9,10}$";
    public static final String NAME_PERSON_REGEX = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})|(\\s[0-9])){0,5}$";


}

