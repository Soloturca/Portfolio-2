package base;

import api.model.JSON.ParameterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;


public class CommonLib {


    //-------------------------------------------------------------------------------------------------------------------------------
    //It allows to wait on the page for as long as required.
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void waitSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------
    // This method compares the given String with a String expression.
    //------------------------------------------------------------------------------------------------------------

    public static boolean controlText(String actualText, String expectedText) {
        boolean flag = false;
        try {
            if (actualText.contains(expectedText)) {
                flag = true;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("The words do not match. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return flag;
    }

    //-------------------------------------------------------------------------------------
    // This method checks if there is a String expression given in the list.
    //-------------------------------------------------------------------------------------

    public static boolean controlText(String expectedText, List<String> oList) {
        boolean flag = false;
        int i = 1;
        for (String text : oList) {
            if (expectedText.contains(text)) {
                flag = true;
                i++;
                if (oList.size() == i) {
                    break;
                }
            }
        }
        return flag;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
    public static String prepJson(Object dataClass) {
        // Creating Object of ObjectMapper define in Jackson API
        ObjectMapper Obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            // Java objects to JSON string - pretty-print
            return Obj.writerWithDefaultPrettyPrinter().writeValueAsString(dataClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
    public static <T> T getResponse(String stringResponse, Class<T> dataClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stringResponse, dataClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
    public static Map<String, String> queryMap(String name, String status, String species, String type, String gender) {
        Map<String, String> map = new HashMap<>();
        try {
            map.put(String.valueOf(ParameterDTO.name), name);
            map.put(String.valueOf(ParameterDTO.status), status);
            map.put(String.valueOf(ParameterDTO.species), species);
            map.put(String.valueOf(ParameterDTO.type), type);
            map.put(String.valueOf(ParameterDTO.gender), gender);
            return map;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String addZeroLeft(String value) {
        boolean status = false;
        StringBuilder valueBuilder = new StringBuilder(value);
        do {
            if (valueBuilder.length() == 10) {
                status = true;
            } else {
                valueBuilder.insert(0, "0");
            }
        } while (!status);
        value = valueBuilder.toString();
        return value;
    }

    public static long generateRandomNumber(int numberCount) {
        Random rnd = new Random();
        char[] digits = new char[numberCount];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for (int i = 1; i < digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public static void allureReport(String status, String message) {
        try {
            if (status.equalsIgnoreCase("PASS")) {
                Allure.step(message, Status.PASSED);
            } else if (status.equalsIgnoreCase("FAIL")) {
                Allure.step(message, Status.FAILED);
            } else {
                Allure.step(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String integerToString(String variable){
        int x = Integer.parseInt(variable.substring(0,variable.lastIndexOf(".")));
        x=x+1;
        variable = Integer.toString(x);
        return variable;
    }

}