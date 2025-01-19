package ru.practicum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchEventParams {
    private String text;

    private List<Long> categories;

    private Boolean paid;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end;

    @Builder.Default
    private Boolean onlyAvailable = false;

    private String sort;

    @PositiveOrZero
    @Builder.Default
    private Integer from = 0;
    @Positive
    @Builder.Default
    private Integer size = 10;
}
