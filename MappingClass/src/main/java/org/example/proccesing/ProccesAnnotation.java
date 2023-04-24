package org.example.proccesing;

import org.example.annotatins.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;;

public class ProccesAnnotation extends Connecting {
    public void mapping(Object o, Connecting conn) throws SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement stmt = conn.connect();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    stringBuilder.append(id).append(" INT PRIMARY KEY not NULL, ");
                    break;
                case "String":
                    String username = i.getName();
                    stringBuilder.append(username).append(" VARCHAR(255) not NULL, ");
                    break;
                case "Integer":
                    String age = i.getName();
                    stringBuilder.append(age).append(" INTEGER not NULL, ");
                    break;
            }
        }
        String createTable = "CREATE TABLE " + tableName + " (" + stringBuilder.toString().substring(0, stringBuilder.length() -2) + ")";
        System.out.println(createTable);
        stmt.executeUpdate(createTable);
    }

    public void deleteTable(Object o, Connecting conn) throws SQLException, ClassNotFoundException {
        Statement stmt = conn.connect();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        String deleteTable = "DROP TABLE " + tableName;
        System.out.println(deleteTable);
        stmt.executeUpdate(deleteTable);
    }
}