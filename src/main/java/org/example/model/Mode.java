package org.example.model;

import org.example.data.Toy;
import org.example.data.ToysDistributor;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Mode {
    protected String nameMenu;
    protected String description;

    public Mode(String nameMenu, String description) {
        this.nameMenu = nameMenu;
        this.description = description;
    }

    public abstract void execute(ToysDistributor toys, Scanner scanner);

    public String getNameMenu() {
        return nameMenu;
    }

    public String getDescription() {
        return description;
    }

    protected Toy getToy(ToysDistributor toys, Scanner scanner, int id) {
        System.out.print("введите имя игрушки ->");
        String name = scanner.next().trim().strip();
        short chanceFalling;
        int quantity;
        try {
            System.out.print("введите количество игрушек ->");
            quantity = scanner.nextInt();
            System.out.print("введите шанс выпадения (1-99) ->");
            chanceFalling = scanner.nextShort();
            if (chanceFalling < 1 || chanceFalling > 99) throw new InputMismatchException();
        } catch (InputMismatchException e) {
            throw new RuntimeException();
        }
        return new Toy(toys.maxId() + id, chanceFalling, quantity, name);
    }
}
