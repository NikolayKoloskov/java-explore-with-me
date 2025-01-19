package ru.practicum.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatedStatusDto {
    private List<Long> idsFromUpdateStatus;
    private List<Long> processedIds;
}
