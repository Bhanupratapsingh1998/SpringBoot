package com.springboot.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDto {
	private Integer categoryId;
	@NotBlank
	@Size(min = 4,message = "Minimum size of title is 4")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 20,message = "Minimum size of title is 20")
	private String categoryDescription;

}
