package com.sector7.math

import kotlin.math.sqrt

data class Vec3f(val x: Float, val y: Float, val z: Float) {
    val sqrMag get() = this dot this
    val mag get() = sqrt(sqrMag)
    val normalized get() = this / mag

    // Swizzle
    val xx get() = Vec2f(x, x)
    val xy get() = Vec2f(x, y)
    val xz get() = Vec2f(x, z)
    val yx get() = Vec2f(y, x)
    val yy get() = Vec2f(y, y)
    val yz get() = Vec2f(y, z)
    val zx get() = Vec2f(z, x)
    val zy get() = Vec2f(z, y)
    val zz get() = Vec2f(z, z)

    constructor(vec: Vec2f, z: Float) : this(vec.x, vec.y, z)

    infix fun dot(rhs: Vec3f) = x * rhs.x + y * rhs.y + z * rhs.z
    infix fun cross(rhs: Vec3f) =
        Vec3f(y * rhs.z - z * rhs.y, z * rhs.x - x * rhs.z, x * rhs.y - y * rhs.x)

    operator fun plus(rhs: Vec3f) = Vec3f(x + rhs.x, y + rhs.y, z + rhs.z)
    operator fun minus(rhs: Vec3f) = Vec3f(x - rhs.x, y - rhs.y, z - rhs.z)
    operator fun times(rhs: Float) = Vec3f(x * rhs, y * rhs, z * rhs)
    operator fun div(rhs: Float) = Vec3f(x / rhs, y / rhs, z / rhs)

    override fun toString() = "<$x, $y, $z>"

    companion object {
        val zero get() = Vec3f(0f, 0f, 0f)
        val one get() = Vec3f(1f, 1f, 1f)
        val right get() = Vec3f(1f, 0f, 0f)
        val left get() = Vec3f(-1f, 0f, 0f)
        val up get() = Vec3f(0f, 1f, 0f)
        val down get() = Vec3f(0f, -1f, 0f)
        val forward get() = Vec3f(0f, 0f, 1f)
        val back get() = Vec3f(0f, 0f, -1f)
    }
}

operator fun Float.times(rhs: Vec3f) = Vec3f(this * rhs.x, this * rhs.y, this * rhs.z)
