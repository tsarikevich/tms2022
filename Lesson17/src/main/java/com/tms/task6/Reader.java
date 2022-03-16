package com.tms.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Reader {
    private String name;
    private String email;
    private boolean isMailing;
    private List<Book> books;
}
