package com.sector7.math

import kotlin.math.cos
import kotlin.math.sin

data class Quatf(val w: Float, val x: Float, val y: Float, val z: Float) {
    operator fun times(rhs: Quatf): Quatf {
        val resultW = w * rhs.w - x * rhs.x - y * rhs.y - z * rhs.z
        val resultX = w * rhs.x + x * rhs.w + y * rhs.z - z * rhs.y
        val resultY = w * rhs.y - x * rhs.z + y * rhs.w + z * rhs.x
        val resultZ = w * rhs.z + x * rhs.y - y * rhs.x + z * rhs.w

        return Quatf(resultW, resultX, resultY, resultZ)
    }

    operator fun times(rhs: Vec3f): Vec3f {
        val xyz = Vec3f(x, y, z)
        val t = 2f * (xyz cross rhs)
        return rhs + (w * t) + (xyz cross t)
    }

    companion object {
        val identity = Quatf(1f, 0f, 0f, 0f)

        fun fromScaledAxis(axis: Vec3f): Quatf {
            val halfAngle = axis.mag / 2f
            val a = axis.normalized
            val scale = sin(halfAngle)
            return Quatf(cos(halfAngle), a.x * scale, a.y * scale, a.z * scale)
        }
    }
}
