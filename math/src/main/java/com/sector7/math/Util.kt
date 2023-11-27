package com.sector7.math

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

fun Float.roundWithDifference() = roundToInt().let { Pair(it, abs(this - it)) }
val Float.floor get() = floor(this).roundToInt()
val Float.ceil get() = ceil(this).roundToInt()
fun Int.clamp(low: Int, high: Int) = min(max(this, low), high)
val Float.clamp01 get() = min(max(this, 0f), 1f)
val Int.isOdd get() = this % 2 == 1
fun ClosedRange<Float>.inverseLerp(x: Float) = (x - start) / (endInclusive - start)
