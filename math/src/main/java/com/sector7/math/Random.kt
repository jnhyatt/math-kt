package com.sector7.math

import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

fun Random.nextUnitVector(): Vec3f {
    val phi = nextFloat() * TAUf
    val theta = acos(nextFloat() * 2f - 1f)
    return Vec3f(sin(theta) * cos(phi), sin(theta) * sin(phi), cos(theta))
}

fun Random.nextRotation() = Quatf.fromScaledAxis(nextUnitVector() * nextFloat() * TAUf)
