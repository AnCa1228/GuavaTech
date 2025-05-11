package com.quark.guavatech.production.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QualityLevelRequest(@NotBlank @Size(max = 50)
                                  String name,
                                  String description) {
}
