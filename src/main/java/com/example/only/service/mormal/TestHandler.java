package com.example.only.service.mormal;

import org.springframework.stereotype.Service;

@Service("TestHandler")
public class TestHandler implements UploadHandler {
    @Override
    public String handleFile() {
        return "abcd";
    }
}
