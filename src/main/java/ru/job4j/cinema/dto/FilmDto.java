package ru.job4j.cinema.dto;

import java.util.Objects;

public class FilmDto {
    private int id;
    private String name;
    private String description;
    private int year;
    private int minimalAge;
    private int durationInMinutes;
    private String genre;
    private int file;

    public FilmDto(int id, String name, String description, int year,
                   int minimalAge, int durationInMinutes, String genre, int file) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
        this.minimalAge = minimalAge;
        this.durationInMinutes = durationInMinutes;
        this.genre = genre;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FilmDto filmDto = (FilmDto) object;
        return id == filmDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
