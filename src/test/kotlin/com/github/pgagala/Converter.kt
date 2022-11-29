package com.github.pgagala

class Converter {
    fun toKilometer(meters: Meter): Kilometer = Kilometer(meters.value / 1000.0)
}
