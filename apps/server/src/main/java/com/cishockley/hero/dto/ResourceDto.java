package com.cishockley.hero.dto;

import jakarta.validation.constraints.NotBlank;

public record ResourceDto(Long id, @NotBlank String name, String category) {

}
