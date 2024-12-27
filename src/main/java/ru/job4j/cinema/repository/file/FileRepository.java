package ru.job4j.cinema.repository.file;

import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.File;

import java.util.Optional;

@Repository
public interface FileRepository {
    Optional<File> findById(int id);
}
