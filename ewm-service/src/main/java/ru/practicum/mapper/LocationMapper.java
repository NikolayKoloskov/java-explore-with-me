package ru.practicum.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.dto.location.LocationDto;
import ru.practicum.model.Location;

@UtilityClass
public class LocationMapper {

    public Location map(LocationDto locationDto) {
        return Location.builder()
                .lat(locationDto.getLat())
                .lon(locationDto.getLon())
                .build();
    }

    public LocationDto map(Location location) {
        return LocationDto.builder()
                .lat(location.getLat())
                .lon(location.getLon())
                .build();
    }
}
