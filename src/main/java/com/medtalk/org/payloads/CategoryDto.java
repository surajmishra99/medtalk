package com.medtalk.org.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 5,message = "Category Title must contains min of 4 characters !!")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10,max = 200,message = "Category Description Max contains only 200 characters !!")
    private String categoryDescription;

}
