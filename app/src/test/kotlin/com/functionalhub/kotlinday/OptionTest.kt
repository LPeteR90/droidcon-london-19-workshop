package com.functionalhub.kotlinday

import arrow.core.*
import io.kotlintest.shouldBe
import org.junit.Test

class OptionTest {

    @Test
    fun `fold Option`() {
        val view = BadgeView()
        val user = User(Badge.toOption())

        view.background = `???`

        view.background shouldBe `???`
    }

    @Test
    fun `fallback Option`() {
        val user = User(None)
        val message = user.badge.getOrElse { "inactive" }

        message shouldBe `???`
    }

    @Test
    fun `safe list access`() {
        val list: List<String> = emptyList()
        val first = list.firstOrNone()

        first shouldBe `???`
    }

}

private data class User(
    val badge: Option<Badge>,
    val isMember: Boolean = false
)

private data class BadgeView(var background: Drawable? = null)

private object Badge {
    val name: String = "active"
}

private sealed class Drawable {
    object InactiveBadgeDrawable : Drawable()
    object ActiveBadgeDrawable : Drawable()
}