package org.adam.resume.website

import androidx.compose.ui.Modifier
import resumewebsite2025.composeapp.generated.resources.Res
import resumewebsite2025.composeapp.generated.resources.backgroundImage1
import resumewebsite2025.composeapp.generated.resources.backgroundImage10
import resumewebsite2025.composeapp.generated.resources.backgroundImage11
import resumewebsite2025.composeapp.generated.resources.backgroundImage12
import resumewebsite2025.composeapp.generated.resources.backgroundImage13
import resumewebsite2025.composeapp.generated.resources.backgroundImage14
import resumewebsite2025.composeapp.generated.resources.backgroundImage15
import resumewebsite2025.composeapp.generated.resources.backgroundImage16
import resumewebsite2025.composeapp.generated.resources.backgroundImage2
import resumewebsite2025.composeapp.generated.resources.backgroundImage3
import resumewebsite2025.composeapp.generated.resources.backgroundImage4
import resumewebsite2025.composeapp.generated.resources.backgroundImage5
import resumewebsite2025.composeapp.generated.resources.backgroundImage6
import resumewebsite2025.composeapp.generated.resources.backgroundImage7
import resumewebsite2025.composeapp.generated.resources.backgroundImage8
import resumewebsite2025.composeapp.generated.resources.backgroundImage9
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun determineXOffset(angle: Float, radius: Float): Float {
    return radius * cos(angle.toRadians())
}

fun determineYOffset(angle: Float, radius: Float): Float {
    return radius * sin(angle.toRadians())
}

fun Float.toRadians(): Float {
    return (this * (PI / 180.0)).toFloat()
}

fun Modifier.thenIf(condition: Boolean, modifier: Modifier): Modifier {
    return this.then(modifier.takeIf { condition } ?: Modifier)
}

fun openUrl(url: String) {
    js("window.open(url, '_blank')")
}

fun openPdf() = openUrl(RESUME_URL)

fun openEmail(to: String = "adam.a.abdelaziz@gmail.com", subject: String = "From your GitHub page", body: String = "") {
    val mailtoLink = "mailto:$to?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(body)}"
    openUrl(mailtoLink)
}

@JsFun("encodeURIComponent")
external fun encodeURIComponent(str: String): String

const val GITHUB_URL = "https://github.com/adamabdelaziz"
const val LINKEDIN_URL = "https://www.linkedin.com/in/adamabdelaziz"
const val RESUME_URL = "https://adamabdelaziz.github.io/static/AdamAbdelazizResume.pdf"

val WORD_LIST = listOf(
    "Kotlin",
    "GraphQL",
    "Koin",
    "Compose Multiplatform",
    "Kotlin Multiplatform",
    "Spring Boot",
    "Flows",
    "LiveData",
    "Coroutines",
    "Datastore",
    "Leak Canary",
    "Dagger Hilt",
    "Ktor",
    "Room",
    "Exposed",
    "PostgreSQL",
    "SQL",
    "Firebase",
    "Jetpack Compose",
    "Retrofit",
    "MVVM",
    "MVI",
    "TDD",
    "Espresso",
    "Use Cases",
).shuffled()

val ABOUT_ME =
    "I'm Adam, a software engineer based in New York City focused on Android development with Kotlin and Jetpack Compose." +
            " I've worked on existing production apps, handling everything from fixing bugs to adding new features that users rely on." +
            " I've also helped build apps from the ground up with teammates, making sure what we ship is solid and scalable." +
            " Over time, I’ve developed an interest in backend development and started building full-stack projects on my own to better understand how everything fits together." +
            " I'm always looking to sharpen my skills and build things that are easy to maintain and use."

val ABOUT_ME_LIST = ABOUT_ME.split("(?<=\\.)".toRegex())
    .filter { it.isNotBlank() }
    .map { it.trim() }

val GOOD_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage3,
    Res.drawable.backgroundImage10,
    Res.drawable.backgroundImage14,
    Res.drawable.backgroundImage15,
)
val LIGHT_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage3,
    Res.drawable.backgroundImage4,
    Res.drawable.backgroundImage5,
    Res.drawable.backgroundImage6,
    Res.drawable.backgroundImage7,
    Res.drawable.backgroundImage8,
    Res.drawable.backgroundImage10,
    Res.drawable.backgroundImage11,
    Res.drawable.backgroundImage12,
    Res.drawable.backgroundImage14,
    Res.drawable.backgroundImage15,
)

val DARK_IMAGE_LIST = listOf(
    Res.drawable.backgroundImage1,
    Res.drawable.backgroundImage2,
    Res.drawable.backgroundImage9,
    Res.drawable.backgroundImage13,
    Res.drawable.backgroundImage16
)