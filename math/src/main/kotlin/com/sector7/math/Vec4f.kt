package com.sector7.math

import kotlin.math.sqrt

data class Vec4f(val x: Float, val y: Float, val z: Float, val w: Float) {
    val sqrMag get() = this dot this
    val mag get() = sqrt(sqrMag)
    val normalized get() = this / mag

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException("Index $index must be between 0 and 3 for Vec4f")
    }

    infix fun dot(rhs: Vec4f) = x * rhs.x + y * rhs.y + z * rhs.z + w * rhs.w

    operator fun plus(rhs: Vec4f) = Vec4f(x + rhs.x, y + rhs.y, z + rhs.z, w + rhs.w)
    operator fun minus(rhs: Vec4f) = Vec4f(x - rhs.x, y - rhs.y, z - rhs.z, w - rhs.w)
    operator fun times(rhs: Float) = Vec4f(x * rhs, y * rhs, z * rhs, w * rhs)
    operator fun div(rhs: Float) = Vec4f(x / rhs, y / rhs, z / rhs, w / rhs)

    override fun toString() = "<$x, $y, $z, $w>"

    companion object {
        val zero get() = Vec4f(0f, 0f, 0f, 0f)
        val one get() = Vec4f(1f, 1f, 1f, 1f)
        val right get() = Vec4f(1f, 0f, 0f, 0f)
        val up get() = Vec4f(0f, 1f, 0f, 0f)
        val forward get() = Vec4f(0f, 0f, 1f, 0f)
    }
}
