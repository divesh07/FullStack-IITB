package industryDemo;
//package com.upgrad.ecommerce.utils.v3

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils(){}

    public static String convertDateToStr(Date inputDate, String outputFormat) throws NullPointerException,IllegalArgumentException{
        String outputDateStr = null;
        try{
            DateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
            outputDateStr = outputDateFormat.format(inputDate);
        }
        catch (NullPointerException npe){
            System.err.println("Got null pointer exception");
            throw npe;
        }
        catch(IllegalArgumentException iae){
            System.err.println("Got illegal argument exception");
            throw iae;
        }
        finally {
            System.out.println("Completing data conversion");
        }
        return outputDateStr;
    }

    public static void main(String[] args) {
        DateUtils.convertDateToStr(new Date(),"dd-mm-yyyy");
    }
}
