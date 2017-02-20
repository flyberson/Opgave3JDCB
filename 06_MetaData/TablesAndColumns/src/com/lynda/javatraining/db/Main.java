package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        ResultSet rsTables = null;
        ResultSet rsColoumns = null;
        ArrayList<String> tables = new ArrayList<>();

        try {

            DatabaseMetaData metadata = conn.getMetaData();
            String[] tableTypes = {"TABLE"};
            rsTables = metadata.getTables(null, "%", "%", tableTypes);
            while (rsTables.next()) {
                tables.add(rsTables.getString("TABLE_NAME"));
            }

            for (String tableName : tables) {
                System.out.println("Table: " + tableName);
                System.out.println("-----------------");
                rsColoumns = metadata.getColumns(null, "%", tableName, "%");

                while (rsColoumns.next()) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(rsColoumns.getString("COLUMN_NAME"));
                    buffer.append(": ");
                    buffer.append(rsColoumns.getString("TYPE_NAME"));
                    System.out.println(buffer.toString());
                }

                System.out.println("");

            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            rsTables.close();
            rsColoumns.close();
        }

        ConnectionManager.getInstance().close();

    }

}
