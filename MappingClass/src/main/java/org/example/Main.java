package org.example;

import org.example.entity.User;
import org.example.proccesing.CRUD.CRUD;
import org.example.proccesing.Connecting;
import org.example.proccesing.ProccesAnnotation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        User user = new User(1L, "'Ivan'", 18);
        Connecting connecting = new Connecting();
        ProccesAnnotation PA = new ProccesAnnotation();
        CRUD crud = new CRUD();

        connecting.connect();
        System.out.println("Выберите нужную операцию: \n 1) Создать таблицу, 2) Записать данные, 3) Вывести данные, 4) Изменить данные, 5) Удалить данные, 6) Удалить таблицу");
        Integer input = scanner.nextInt();

        if (input == 1) {
            PA.mapping(user, connecting);
        } if(input == 2) {
            crud.insert(user, connecting);
        } if (input == 3) {
            crud.select(user, connecting);
        } if (input == 4) {
            crud.update(user, connecting);
        } if (input == 5) {
            crud.delete(user, connecting);
        } if (input == 6) {
            PA.deleteTable(user, connecting);
        }
    }
}