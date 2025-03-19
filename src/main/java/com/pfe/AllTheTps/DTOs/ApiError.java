package com.pfe.AllTheTps.DTOs;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ApiError {
    private final String code;
    private final List<String> message;
    private final LocalDate timestamp;
}
