package com.quark.guavatech.supply.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplyRequest {
    @NotBlank(message = "El nombre del insumo no puede estar vacío")
    @Size(max = 100, message = "El nombre del insumo no puede exceder los 100 caracteres")
    private String name;

    @NotBlank(message = "La unidad del insumo no puede estar vacía")
    @Size(max = 20, message = "La unidad del insumo no puede exceder los 20 caracteres")
    private String unit;

    @NotNull(message = "La cantidad disponible no puede ser nula")
    @PositiveOrZero(message = "La cantidad disponible no puede ser negativa")
    private double availableQuantity;

    @NotNull(message = "El costo unitario no puede ser nulo")
    @PositiveOrZero(message = "El costo unitario no puede ser negativo")
    private double unitCost;
}
