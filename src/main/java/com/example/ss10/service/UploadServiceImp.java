package com.example.ss10.service;

import com.example.ss10.model.UploadFile;
import com.example.ss10.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImp implements UploadService {
    @Autowired
    private UploadRepository uploadRepository;

    @Override
    public boolean upload(UploadFile uploadFile) {
        return uploadRepository.upload(uploadFile);
    }
}
