package ru.job4j.cinema.service.file;

import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.repository.file.FileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleFileService implements FileService {
    private final FileRepository fileRepository;
    private final String storageDirectory;

    public SimpleFileService(FileRepository fileRepository, @Value("${file.directory}") String storageDirectory) {
        this.fileRepository = fileRepository;
        this.storageDirectory = storageDirectory;
        createStorageDirectory(storageDirectory);
    }

    private void createStorageDirectory(String path) {
        try {
            Files.createDirectories(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FileDto> findById(int id) {
        var fileOptional = fileRepository.findById(id);
        if (fileOptional.isEmpty()) {
            return Optional.empty();
        }
        var content = readFile(fileOptional.get().getPath());
        return Optional.of(new FileDto(fileOptional.get().getName(), content));
    }

    private byte[] readFile(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}