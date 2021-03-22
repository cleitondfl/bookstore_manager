package com.cleitonlima.bookstoremanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {


    private Long id;

    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 100)
    private Integer age;

}
