package com.sector7.math

data class Vec2i(val x: Int, val y: Int) {
    operator fun plus(rhs: Vec2i) = Vec2i(x + rhs.x, y + rhs.y)
    operator fun minus(rhs: Vec2i) = Vec2i(x - rhs.x, y - rhs.y)
    operator fun times(rhs: Number) = Vec2i(
        (x * rhs.toFloat()).toInt(), (y * rhs.toFloat()).toInt()
    )

    override fun toString() = "<$x, $y>"

    fun toVec2f() = Vec2f(x.toFloat(), y.toFloat())

    companion object {
        val zero get() = Vec2i(0, 0)
        val one get() = Vec2i(1, 1)
        val right get() = Vec2i(1, 0)
        val left get() = Vec2i(-1, 0)
        val up get() = Vec2i(0, 1)
        val down get() = Vec2i(0, -1)
    }
}
