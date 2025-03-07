package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.service.file.FileService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileControllerTest {

    private FileController fileController;
    private FileService fileService;

    @BeforeEach
    void init() {
        fileService = mock(FileService.class);
        fileController = new FileController(fileService);
    }

    @Test
    void whenFileExistsThenReturnOkResponseWithContent() {
        var fileContent = new byte[]{1, 2, 3, 4, 5};
        var fileDto = new FileDto("testFile", fileContent);
        when(fileService.findById(1)).thenReturn(Optional.of(fileDto));
        ResponseEntity<?> response = fileController.getById(1);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(fileContent);
    }

    @Test
    void whenFileDoesNotExistThenReturnNotFoundResponse() {
        when(fileService.findById(1)).thenReturn(Optional.empty());
        ResponseEntity<?> response = fileController.getById(1);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }
}