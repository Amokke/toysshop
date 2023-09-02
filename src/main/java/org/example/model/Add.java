package org.example.model;

import org.example.data.Toy;
import org.example.data.ToysDistributor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Add extends Mode {

    public Add() {
        super("add", "добавить");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        toys.addToy(getToy(toys, scanner, 1));
        System.out.println("-> добавлено успешно");
    }
}
