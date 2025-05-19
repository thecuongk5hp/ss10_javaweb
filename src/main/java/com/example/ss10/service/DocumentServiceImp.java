package com.example.ss10.service;

import com.example.ss10.model.Document;
import com.example.ss10.repository.AccountRepository;
import com.example.ss10.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImp implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean createDocument(Document document) {
        return documentRepository.createDocument(document);
    }
}
