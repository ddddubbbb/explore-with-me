package ru.practicum.category.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@RequiredArgsConstructor
public class NewCategoryDto {

    @Size(min = 1, max = 50)
    @NotNull
    @NotBlank
    private String name;
}