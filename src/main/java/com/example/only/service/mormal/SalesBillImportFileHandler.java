package com.example.only.service.mormal;

import org.springframework.stereotype.Service;

@Service("SalesBillImportFileHandler")
public class SalesBillImportFileHandler implements UploadHandler {

    @Override
    public String handleFile() {
        return "456";
    }


}

