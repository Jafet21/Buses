package controllers;

import com.google.common.collect.ImmutableMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Collections;

public class IndexController {

    public ModelAndView index(Request request, Response response){
        return new ModelAndView(Collections.emptyMap(), "index.vm");
    }

    public ModelAndView saludo(Request request, Response response){
        return new ModelAndView(ImmutableMap.of("name", request.params(":name")), "saludo.vm");
    }
}
