package ru.practicum.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.practicum.model.Category;

/**
 * DTO for {@link Category}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewCategoryDto {
    @Size(min = 1, max = 50)
    @NotBlank
    private String name;
}