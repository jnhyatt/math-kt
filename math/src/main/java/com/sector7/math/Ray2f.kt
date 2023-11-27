package com.sector7.math

data class Ray2f(val origin: Vec2f, val direction: Vec2f) {
    fun lerp(x: Float) = origin + direction * x

    companion object {
        fun fromTo(origin: Vec2f, target: Vec2f) = Ray2f(origin, target - origin)
    }
}
