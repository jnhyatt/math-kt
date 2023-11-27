package com.sector7.math

data class Rect2f(val bottomLeft: Vec2f, val topRight: Vec2f) {
    val center get() = (bottomLeft + topRight) / 2f
    val size get() = topRight - bottomLeft
}
