package com.example;


import java.nio.charset.StandardCharsets;
import java.util.Map;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;

@Controller
public class ExampleController {

    private static final String TEXT = "français";

    @Get("/view")
    public HttpResponse<ModelAndView<Map<String, String>>> view() {
        return HttpResponse.ok(new ModelAndView<>("view", Map.of("text", TEXT)))
            .contentType(MediaType.TEXT_PLAIN_TYPE)
            .characterEncoding(StandardCharsets.ISO_8859_1);
    }

    @Get("/text")
    public HttpResponse<?> text() {
        return HttpResponse.ok(TEXT)
            .contentType(MediaType.TEXT_PLAIN_TYPE)
            .characterEncoding(StandardCharsets.ISO_8859_1);
    }
}
