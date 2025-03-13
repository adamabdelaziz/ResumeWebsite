package org.adam.resume.website.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeft
import compose.icons.feathericons.ArrowRight
import compose.icons.feathericons.Github
import kotlinx.coroutines.launch
import org.adam.resume.website.WORD_LIST
import org.adam.resume.website.openUrl
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun ProjectPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { PAGE_COUNT })
    val scope = rememberCoroutineScope()

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

                HeaderIcon(
                    modifier = Modifier.alpha(if (pagerState.currentPage == 0) 0f else 1f).size(48.dp).padding(end = 8.dp),
                    imageVector = FeatherIcons.ArrowLeft,
                    onClick = {
                        if (pagerState.currentPage > 0) {
                            scope.launch {
                                pagerState.scrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    },
                )

                Crossfade(modifier = Modifier.weight(1f).padding(end = 8.dp), targetState = page, label = "PageCrossfade") { currentPage ->
                    when (currentPage) {
                        0 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[0]
                        )

                        1 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[1]
                        )

                        2 -> ProjectView(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp).background(CurrentColors.background),
                            project = projectList[2]
                        )
                    }
                }

                HeaderIcon(
                    modifier = Modifier.alpha(if (pagerState.currentPage != (PAGE_COUNT - 1)) 1f else 0f).size(48.dp).padding(end = 8.dp),
                    imageVector = FeatherIcons.ArrowRight,
                    onClick = {
                        if (pagerState.currentPage < PAGE_COUNT) {
                            scope.launch {
                                pagerState.scrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    },
                )

            }
        }
    }
}

@Composable
fun ProjectRow(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        projectList.forEach {
            ProjectView(
                modifier = Modifier.weight(1f).fillMaxHeight(0.4f).padding(horizontal = 16.dp)
                    .background(CurrentColors.secondary, shape = RoundedCornerShape(48.dp)),
                project = it
            )
        }
    }
}

@Composable
fun ProjectColumn(modifier: Modifier = Modifier, height: Dp) {
    Box(modifier) {
        RainingWordsAnimation(modifier = Modifier.fillMaxSize(), WORD_LIST)
        Column(modifier) {
            projectList.forEach {
                Column(modifier = modifier.height(height), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    ProjectView(
                        modifier = modifier.padding(horizontal = 24.dp)
                            .background(CurrentColors.secondary, shape = RoundedCornerShape(48.dp)),
                        project = it
                    )
                }
            }
        }
    }

}

@Composable
fun ProjectView(
    modifier: Modifier = Modifier,
    project: Project,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = project.title,
            color = CurrentColors.onSecondary,
            style = CurrentTypography.h1,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = project.blurb,
            color = CurrentColors.onSecondary,
            style = CurrentTypography.h2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 16.dp)
        )

        project.points.forEach { point ->
            Text(
                text = "• $point",
                color = CurrentColors.onSecondary,
                style = CurrentTypography.h2,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }

        project.githubUrl?.let {
            HeaderIcon(
                onClick = { openUrl(it) },
                imageVector = FeatherIcons.Github,
            )
        }
    }
}

const val PAGE_COUNT = 3

data class Project(
    val title: String,
    val blurb: String,
    val points: List<String>,
    val githubUrl: String? = null,
)

val kovidProject = Project(
    title = "Kovid",
    blurb = "Android app to track COVID-19 cases in your area.",
    points = listOf(
        "Used a now deprecated COVID-19 API to fetch data for the USA as well as each state",
        "MVVM architecture with LiveData and viewbinding with XML for UI",
        "Hilt for dependency injection and Jetpack Room for persistence"
    )
)

val kryptoProject = Project(
    title = "Krypto",
    blurb = "Kotlin Multiplatform (Desktop) app to track Solana tokens as well as swap them based on inputted parameters.",
    points = listOf(
        "Uses the DexScreener API to fetch up to date crypto prices.",
        "Uses the Jupiter API to get quotes and swap Solana tokens",
        "MVI architecture with Kotlin Flow and Jetpack Compose for UI",
        "Ktor for network calls and Koin for dependency injection",
    )
)

val composeWeather = Project(
    title = "Compose Weather",
    blurb = "Android app to track the weather in your area.",
    points = listOf(
        "Uses the OpenWeather API to fetch up to date weather based on user location.",
        "MVVM architecture with LiveData and Jetpack Compose for UI",
        "Jetpack Room for persistence and DataStore for user settings",
        "Hilt for dependency injection and Retrofit for network calls"
    )
)

val projectList = listOf(kryptoProject, composeWeather, kovidProject)