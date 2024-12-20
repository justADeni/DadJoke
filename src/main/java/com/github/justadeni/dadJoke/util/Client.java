package com.github.justadeni.dadJoke.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    private static final HttpClient client = HttpClient.newHttpClient();

    private static final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://icanhazdadjoke.com/"))
            .header("User-Agent", "Application: https://github.com/justADeni/DadJoke (a minecraft server plugin) / Discord: justADeni") // set the User-Agent header
            .header("Accept", "text/plain")
            .GET()
            .build();

    public static String getJoke() {
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (java.io.IOException | java.lang.InterruptedException exception) {
            return "";
        }
    }

}
