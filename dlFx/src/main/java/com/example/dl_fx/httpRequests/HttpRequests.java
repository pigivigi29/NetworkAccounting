package com.example.dl_fx.httpRequests;

import com.example.dl_spring.dto.AuthorizedUserDto;
import com.example.dl_spring.dto.main.MainDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequests<T> {

    public static final String URI = "http://localhost:8080/";

    public static String TOKEN = "";

    public static  String AuthRequest(AuthorizedUserDto dto, String uri) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + uri))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(dto)))
                .build();
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }

    public static <T extends MainDto> JsonNode PostRequest(T dto, String uri) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + uri))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + TOKEN)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(dto)))
                .build();
        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );
        InputStream responseBody = response.body();
        return objectMapper.readTree(responseBody);
    }

    public static JsonNode GetRequest(String uri) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + uri))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + TOKEN)
                .GET()
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );
        InputStream responseBody = response.body();
        return objectMapper.readTree(responseBody);
    }

    public static <T extends MainDto> JsonNode PutRequest(T dto, String uri) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + uri))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + TOKEN)
                .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(dto)))
                .build();
        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );
        InputStream responseBody = response.body();
        return objectMapper.readTree(responseBody);
    }

    public static JsonNode DeleteRequest(String uri) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + uri))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + TOKEN)
                .DELETE()
                .build();
        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );
        InputStream responseBody = response.body();
        return objectMapper.readTree(responseBody);
    }
}
