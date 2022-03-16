package com.tms.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Library {
    private List<Book> books;
    private List<Reader> readers;
}
