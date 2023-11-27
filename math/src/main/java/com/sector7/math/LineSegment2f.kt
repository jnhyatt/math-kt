package com.sector7.math

data class LineSegment2f(val start: Vec2f, val end: Vec2f) {
    val direction get() = end - start

    fun lerp(t: Float) = start + direction * t

    fun intersection(other: Ray2f): Vec2f? {
        val t = ((other.origin - start).perp dot other.direction) / (direction.perp dot other.direction)
        val u = ((start - other.origin).perp dot direction) / (other.direction.perp dot direction)
        return if (u >= 0f && t in 0f..1f) lerp(t) else null
    }
}
