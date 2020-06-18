package com.example.authmodule.utils;

import com.example.authmodule.models.MessageAWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.*;

import java.io.IOException;

public class OkHttp {
    private String url = "http://notificationbysms-env.eba-xy3m8g5c.sa-east-1.elasticbeanstalk.com/api/send";
    private OkHttpClient httpClient = new OkHttpClient();

    public OkHttp(){
    }

    public void sendGET() {

        Request request = new Request.Builder()
                .url("https://httpbin.org/get")
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println(responseBody.string());
                }
            }
        });

    }

    public void sendPOST(MessageAWS noti) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
             json = mapper.writeValueAsString(noti);
            System.out.println("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(this.url)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }

    }

}