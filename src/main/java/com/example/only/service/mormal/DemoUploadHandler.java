package com.example.only.service.mormal;

import org.springframework.stereotype.Component;

@Component("DemoUploadHandler")
public class DemoUploadHandler implements UploadHandler {
    @Override
    public String handleFile() {
        return "123";
    }
}
