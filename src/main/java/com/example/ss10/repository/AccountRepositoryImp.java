package com.example.ss10.repository;

import com.example.ss10.connection.ConnectionDB;
import com.example.ss10.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class AccountRepositoryImp implements AccountRepository {
    @Override
    public boolean createAccount(Account account) {
        Connection conn = null;
        CallableStatement cstmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_account(?, ?, ?)}");
            cstmt.setString(1, account.getUsername());
            cstmt.setString(2, account.getPassword());
            cstmt.setString(3, account.getEmail());
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
