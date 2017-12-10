package com.luwojtaszek.springbootjsp.Utils;


import com.luwojtaszek.springbootjsp.dao.Customer;
import org.springframework.http.HttpStatus;

public class CustomerHelperValidator {
    public static final int AGE_DEFAULT = 0;
    public static final int AGE_MIN = 16;
    public static final int AGE_MAX = 100;
    public static final int NAME_MIN_LEN = 2;
    public static final int NAME_MAX_LEN = 50;
    public static final int EMAIL_MAX_LEN = 50;
    public static final int EMAIL_MIN_LEN = 6;
    public static final String LAST_NAME = "last name ";
    public static final String FIRST_NAME = "first name ";
    public static final String AGE = "age ";
    public static final String EMAIL = "email ";
    public static  String MESSAGE_ERROR = "%s value does not meet the requirements.\r\n";
    public static final String EMAIL_MESSAGE_ERROR = "";

    private static final Object locker = new Object();

    public static ResponseResolve customerValidation(Customer customer){
        String message = "";
        ResponseResolve responseResolve;
        synchronized (locker) {
            message += ageValidate(customer.getAge())==true ? message : String.format(MESSAGE_ERROR,AGE);
            message += emailValidate(customer.getEmail())==true ? message : String.format(MESSAGE_ERROR,EMAIL);
            message += nameValidate(customer.getFirstName())==true ? message : String.format(MESSAGE_ERROR,FIRST_NAME);
            message += nameValidate(customer.getLastName())==true ? message : String.format(MESSAGE_ERROR,LAST_NAME);
            responseResolve = message.equals("") ? new ResponseResolve(HttpStatus.OK.value(),"") :
                    new ResponseResolve(HttpStatus.NOT_FOUND.value(),message);

            return responseResolve;
        }
    }

    private static boolean ageValidate(int age){
        return age>=AGE_MIN && age<=AGE_MAX;
    }

    //check without regex :-)
    private static boolean emailValidate(String email){
        return email!=null && email.length()>=EMAIL_MIN_LEN && email.length()<=EMAIL_MAX_LEN;
    }

    private static boolean nameValidate(String name){
        return name!=null && name.length()>=NAME_MIN_LEN && name.length()<=NAME_MAX_LEN;
    }
}
