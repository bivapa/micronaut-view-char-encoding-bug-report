package com.example;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class ExampleControllerTest {

    private static final String TEXT = "français";

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    void testViewControllerReturnsDefinedMediaType() {
        var response = client.toBlocking().exchange("/view");
        assertEquals(MediaType.TEXT_PLAIN, response.getContentType().get().getName());
    }

    @Test
    void testViewControllerReturnsDefinedCharacterEncoding() {
        var response = client.toBlocking().exchange("/view");
        assertEquals(StandardCharsets.ISO_8859_1, response.getCharacterEncoding());
    }

    @Test
    void testViewControllerEncodesCorrectCharacters() {
        var response = client.toBlocking().exchange("/view");
        assertEquals(TEXT, response.getBody(String.class).get());
    }

    @Test
    void testTextControllerReturnsDefinedMediaType() {
        var response = client.toBlocking().exchange("/text");
        assertEquals(MediaType.TEXT_PLAIN, response.getContentType().get().getName());
    }

    @Test
    void testTextControllerReturnsDefinedCharacterEncoding() {
        var response = client.toBlocking().exchange("/text");
        assertEquals(StandardCharsets.ISO_8859_1, response.getCharacterEncoding());
    }

    @Test
    void testTextControllerEncodesCorrectCharacters() {
        var response = client.toBlocking().exchange("/text");
        assertEquals(TEXT, response.getBody(String.class).get());
    }
}
