package com.sector7.math

data class Polygon2f(val points: List<Vec2f>) {
    val lineSegments
        get() = (points + points.first()).windowed(2, 1, false).map {
            LineSegment2f(it[0], it[1])
        }

    fun contains(point: Vec2f) =
        lineSegments.count { it.intersection(Ray2f(point, Vec2f.right)) != null }.isOdd
}
