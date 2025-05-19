package com.example.ss10.repository;

import com.example.ss10.connection.ConnectionDB;
import com.example.ss10.model.Document;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class DocumentRepositoryImp implements DocumentRepository {
    @Override
    public boolean createDocument(Document document) {
        Connection conn = null;
        CallableStatement cstmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_doccument(?, ?, ?)}");
            cstmt.setString(1, document.getTitle());
            cstmt.setString(2, document.getDescription());
            cstmt.setBytes(3, document.getFile().getBytes());
            cstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return result;
    }
}
