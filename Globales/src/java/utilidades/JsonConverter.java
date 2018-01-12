/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 *
 * @author Jose
 */
public class JsonConverter {

    private static Gson converter;

    private JsonConverter() {
    }
    
    private static Gson getConverter() {
        if (converter == null) {
            converter = new Gson();
        }
        return converter;
    }

    public static String convertToString(Object o) {
        return getConverter().toJson(o);
    }

    public static Object convertToObject(String s, Type clas) {
        return getConverter().fromJson(s, clas);
    }
}
