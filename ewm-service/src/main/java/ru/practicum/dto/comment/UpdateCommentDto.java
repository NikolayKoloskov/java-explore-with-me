package ru.practicum.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.practicum.model.Comment;

/**
 * DTO for {@link Comment}
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateCommentDto {
    @NotNull
    @Size(message = "Допустимый размер комментария от 1 до 2000 символов", min = 1, max = 2000)
    @NotBlank
    private final String text;
}