package ru.practicum.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import ru.practicum.model.Comment;

/**
 * DTO for {@link Comment}
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor(force = true)
@Builder
public class NewCommentDto {
    @NotBlank(message = "Коментарий не может быть пустой")
    @Size(message = "Допустимый размер коментария от 1 до 2000 символов",min = 1, max = 2000)
    private final String text;
}