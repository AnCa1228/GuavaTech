package com.quark.guavatech.croplot.dto;

import java.time.LocalDate;

public record CropLotResponse(Long lotId,
                              String name,
                              String location,
                              LocalDate startDate) {}
