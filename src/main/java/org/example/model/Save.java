package org.example.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.ToysDistributor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Save extends Mode {

    public Save() {
        super("save", "сохранить в файл");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        String path = "C://toys.json";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(toys.getToys());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } try {
            Files.write(Paths.get(path),
                    jsonString.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("err: ошибка при записи файла");;
        }
        System.out.println("-> сохранено успешно");
    }
}
