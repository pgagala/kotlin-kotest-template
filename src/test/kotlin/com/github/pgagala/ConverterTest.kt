package com.github.pgagala

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class ConverterTest : StringSpec({
    val converter = Converter()

    "Converter should convert meters to kilometers" {
        io.kotest.data.forAll(
            table(
                headers("meters", "expected kilometers"),
                row(Meter(1000), Kilometer(1.0)),
                row(Meter(1100L), Kilometer(1.1)),
                row(Meter(3999L), Kilometer(3.999)),
                row(Meter(333L), Kilometer(0.333))
            )
        ) { meters: Meter, kilometers: Kilometer ->
            converter.toKilometer(meters) shouldBe kilometers
        }
    }
})
