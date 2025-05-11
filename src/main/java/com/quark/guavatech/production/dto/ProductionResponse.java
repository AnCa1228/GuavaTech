package com.quark.guavatech.production.dto;

import java.time.LocalDate;

public record ProductionResponse(Long productionId,
                                 LocalDate harvestDate,
                                 Double producedQuantity,
                                 String qualityNotes,
                                 Long lotId,
                                 String lotName,
                                 Long qualityId,
                                 String qualityName) {
}
