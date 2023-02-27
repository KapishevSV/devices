package ru.ksv.devices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsdDto {
    private String sn;

    private String locate;

    @JsonProperty("Type")
    TypeDto typeDto;
}
