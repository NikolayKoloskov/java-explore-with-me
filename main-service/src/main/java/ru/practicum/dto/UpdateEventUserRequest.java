package ru.practicum.dto;

import lombok.*;
import ru.practicum.model.enums.EventUserState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventUserRequest extends UpdateEventRequest {

    private EventUserState stateAction;

}
