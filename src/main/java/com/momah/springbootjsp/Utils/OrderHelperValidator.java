package com.momah.springbootjsp.Utils;

import com.momah.springbootjsp.dao.OrderCust;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class OrderHelperValidator {
    public static final int CUSTOMER_ID_DEFAULT = -1;
    public static final double PRICE_DEFAULT = 0.00;
    private static final Object locker = new Object();
    public static final int CUSTOMER_ID_MIN = 1;
    public static final int QUANTITY_MIN = 1;
    public static final String QUANTITY = "quantity ";
    public static final String DATE = "date ";
    public static final String CUSTOMER_ID = "customer_id ";
    public static final String PRICE = "PRICE ";
    public static  String MESSAGE_ERROR = "%svalue does not meet the requirements\r";


    public static ResponseResolve orderValidation(OrderCust order){
        String message = "";
        ResponseResolve responseResolve;
        message +=dateValidate(order.getDate())==true ? "" : String.format(MESSAGE_ERROR,DATE);
        message +=customerIdValidate(order.getCustomerId())==true ? "" : String.format(MESSAGE_ERROR,CUSTOMER_ID);
        message +=quantityValidate(order.getQuantity())==true ? "" : String.format(MESSAGE_ERROR,QUANTITY);
        message +=priceValidate(order.getPrice())==true ? "" : String.format(MESSAGE_ERROR,PRICE);
        responseResolve = message.equals("") ? new ResponseResolve(HttpStatus.OK.value(),"") :
                new ResponseResolve(HttpStatus.BAD_REQUEST.value(),message);
        return responseResolve;

    }

    //need to check time to can be converted from String to LocalDateTime
    private static boolean dateValidate(LocalDateTime localDateTime){
        return localDateTime !=null ;
    }

    private static boolean customerIdValidate(long id){
        return id>=CUSTOMER_ID_MIN;
    }

    private static boolean quantityValidate(int quantity){
        return quantity >= QUANTITY_MIN;
    }

    private static boolean priceValidate(double price){
        return price > PRICE_DEFAULT;
    }
}
