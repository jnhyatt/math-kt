package com.sector7.math

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class Vec2f(val x: Float, val y: Float) {
    val sqrMag get() = this dot this
    val mag = sqrt(sqrMag)
    val normalized get() = this / mag

    operator fun unaryMinus() = Vec2f(-x, -y)
    operator fun plus(rhs: Vec2f) = Vec2f(x + rhs.x, y + rhs.y)
    operator fun minus(rhs: Vec2f) = Vec2f(x - rhs.x, y - rhs.y)
    operator fun times(rhs: Number) = Vec2f(x * rhs.toFloat(), y * rhs.toFloat())
    operator fun div(rhs: Number) = Vec2f(x / rhs.toFloat(), y / rhs.toFloat())

    val perp get() = Vec2f(-y, x)

    infix fun dot(rhs: Vec2f) = x * rhs.x + y * rhs.y

    fun toVec3f(z: Float) = Vec3f(x, y, z)

    override fun toString() = "<$x, $y>"

    companion object {
        val zero get() = Vec2f(0f, 0f)
        val one get() = Vec2f(1f, 1f)
        val right get() = Vec2f(1f, 0f)
        val left get() = Vec2f(-1f, 0f)
        val up get() = Vec2f(0f, 1f)
        val down get() = Vec2f(0f, -1f)

        fun fromAngle(angle: Float) = Vec2f(cos(angle), sin(angle))
    }
}

operator fun Float.times(rhs: Vec2f) = Vec2f(this * rhs.x, this * rhs.y)
