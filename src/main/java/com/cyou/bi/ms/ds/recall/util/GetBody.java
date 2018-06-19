package com.cyou.bi.ms.ds.recall.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetBody {
    private static final Logger logger = LoggerFactory
            .getLogger(GetBody.class);
    public String getBody(HttpServletRequest request,
                          HttpServletResponse response){
        String body = "";
        try {
            InputStream input = request.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(input, output);
            input.close();
            output.close();
            body = new String(output.toByteArray(), "utf-8");
        } catch (IOException e) {
            logger.info("body" + body);
            try {
                response.sendError(500, "service error:read http body error");
                return "";
            } catch (IOException e1) {
                logger.error("response error", e1);
                return "";
            }
        }
        return body;
    }
}
