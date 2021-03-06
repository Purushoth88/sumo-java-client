package com.sumologic.client.util;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class DeserializingResponseHandler<Request, Response>
        implements ResponseHandler<Request, Response> {

    private Class<Response> clazz;

    public DeserializingResponseHandler(Class<Response> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Response handle(HttpResponse httpResponse, InputStream httpStream, Request request)
            throws IOException {

        return JacksonUtils.MAPPER.readValue(httpStream, clazz);
    }
}
