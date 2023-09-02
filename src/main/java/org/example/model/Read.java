package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.Toy;
import org.example.data.ToysDistributor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Read extends Mode {

    public Read() {
        super("read", "загрузить из файла");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        String path = "C://toys.json";
        List<Toy> temp;
        ObjectMapper mapper = new ObjectMapper();
        try {
            temp = Arrays.asList(mapper.readValue(new File(path), Toy[].class));
        } catch (IOException e) {
            System.out.println("err: такого файла не существует");
            return;
        }
        toys.setToys(new PriorityQueue<>(temp));
        System.out.println("-> загружено успешно");
    }
}
