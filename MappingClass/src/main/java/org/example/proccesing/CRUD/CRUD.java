package org.example.proccesing.CRUD;

import org.example.annotatins.Column;
import org.example.annotatins.Table;
import org.example.proccesing.Connecting;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD extends Connecting {

    public void insert(Object o, Connecting conn) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBulder = new StringBuilder();
        Statement stmt = conn.connect();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    Long id = (Long) i.get(o);
                    stringBulder.append(id).append(", ");
                    break;
                case "String":
                    String username = (String) i.get(o);
                    stringBulder.append(username).append(", ");
                    break;
                case "Integer":
                    Integer age = (Integer) i.get(o);
                    stringBulder.append(age).append(", ");
                    break;
            }
        }
        String insertTable = "INSERT INTO " + tableName + " VALUES (" + stringBulder.toString().substring(0, stringBulder.length() - 2) + ")";
        System.out.println(insertTable);
        stmt.executeUpdate(insertTable);
    }

    public void select(Object o, Connecting conn) throws SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement stmt = conn.connect();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    stringBuilder.append(id).append(", ");
                    break;
                case "String":
                    String username = i.getName();
                    stringBuilder.append(username).append(", ");
                    break;
                case "Integer":
                    String age = i.getName();
                    stringBuilder.append(age).append(", ");
                    break;
            }
        }
        String selectTable = "SELECT " + stringBuilder.toString().substring(0, stringBuilder.length() -2) + " FROM " + tableName;
        System.out.println(selectTable);
        stmt.execute(selectTable);
    }

    public void update(Object o, Connecting conn) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement stmt = conn.connect();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i:clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    Long valueId = (Long) i.get(o);
                    stringBuilder.append(id).append("=" + valueId).append(", ");
                    break;
                case "String":
                    String username = i.getName();
                    String valueUserName = (String) i.get(o);
                    stringBuilder.append(username).append("=" + valueUserName).append(", ");
                    break;
                case "Integer":
                    String age = i.getName();
                    Integer valueAge = (Integer) i.get(o);
                    stringBuilder.append(age).append("=" + valueAge).append(", ");
                    break;
            }
        }
        String updateTable = "UPDATE " + tableName + " SET " + stringBuilder.toString().substring(0, stringBuilder.length() -2);
        System.out.println(updateTable);
        stmt.executeUpdate(updateTable);
    }

    public void delete(Object o, Connecting conn) throws SQLException, ClassNotFoundException, IllegalAccessException {
        StringBuilder stringBulder = new StringBuilder();
        Class<? extends Object> clazz = o.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();
        Statement stmt = conn.connect();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    Long valueId = (Long) i.get(o);
                    stringBulder.append(id).append("=" + valueId);
                    break;
            }
        }
        String deleteTable = "DELETE FROM " + tableName + " WHERE " + stringBulder.toString().substring(0, stringBulder.length());
        System.out.println(deleteTable);
        stmt.executeUpdate(deleteTable);
    }
}