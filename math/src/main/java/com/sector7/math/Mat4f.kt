package com.sector7.math

import kotlin.math.tan

class Mat4f private constructor(private val columns: Array<Vec4f>) {
    operator fun get(m: Int, n: Int) = columns[n][m]

    fun row(index: Int) =
        Vec4f(columns[0][index], columns[1][index], columns[2][index], columns[3][index])

    fun col(index: Int) = columns[index]

    operator fun times(rhs: Vec4f) =
        Vec4f(row(0) dot rhs, row(1) dot rhs, row(2) dot rhs, row(3) dot rhs)

    operator fun times(rhs: Mat4f) = Mat4f(rhs.columns.map { this * it }.toTypedArray())

    val asColumnMajorArray
        get() = columns.flatMap { sequenceOf(it.x, it.y, it.z, it.w) }.toFloatArray()

    companion object {
        val identity get() = translation(Vec3f.zero)

        fun translation(amount: Vec3f) = Mat4f(
            arrayOf(Vec4f.right, Vec4f.up, Vec4f.forward, Vec4f(amount.x, amount.y, amount.z, 1f))
        )

        fun rotation(amount: Quatf): Mat4f {
            val xx = amount.x * amount.x
            val xy = amount.x * amount.y
            val xz = amount.x * amount.z
            val xw = amount.x * amount.w

            val yy = amount.y * amount.y
            val yz = amount.y * amount.z
            val yw = amount.y * amount.w

            val zz = amount.z * amount.z
            val zw = amount.z * amount.w

            return Mat4f(
                arrayOf(
                    Vec4f(1.0f - 2.0f * (yy + zz), 2.0f * (xy - zw), 2.0f * (xz + yw), 0.0f),
                    Vec4f(2.0f * (xy + zw), 1.0f - 2.0f * (xx + zz), 2.0f * (yz - xw), 0.0f),
                    Vec4f(2.0f * (xz - yw), 2.0f * (yz + xw), 1.0f - 2.0f * (xx + yy), 0.0f),
                    Vec4f(0.0f, 0.0f, 0.0f, 1.0f)
                )
            )
        }

        fun perspective(fovY: Float, aspectRatio: Float, clipNear: Float, clipFar: Float) = Mat4f(
            arrayOf(
                Vec4f(1f / (aspectRatio * tan(fovY / 2f)), 0f, 0f, 0f),
                Vec4f(0f, 1f / tan(fovY / 2f), 0f, 0f),
                Vec4f(0f, 0f, -(clipFar + clipNear) / (clipFar - clipNear), -1f),
                Vec4f(0f, 0f, -2f * clipFar * clipNear / (clipFar - clipNear), 0f)
            )
        )
    }
}
