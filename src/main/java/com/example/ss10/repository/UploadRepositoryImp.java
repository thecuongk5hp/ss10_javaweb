package com.example.ss10.repository;

import com.example.ss10.connection.ConnectionDB;
import com.example.ss10.model.UploadFile;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class UploadRepositoryImp implements UploadRepository {
    @Override
    public boolean upload(UploadFile uploadFile) {
        Connection conn = null;
        CallableStatement cstmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_UploadFile(?, ?)}");
            cstmt.setString(1, uploadFile.getFile().getOriginalFilename());
            cstmt.setString(2, uploadFile.getDescription());
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
