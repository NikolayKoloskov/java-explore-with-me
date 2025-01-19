package ru.practicum.dto;

import lombok.*;
import ru.practicum.model.enums.EventAdminState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventAdminRequest extends UpdateEventRequest {

    private EventAdminState stateAction;
}
