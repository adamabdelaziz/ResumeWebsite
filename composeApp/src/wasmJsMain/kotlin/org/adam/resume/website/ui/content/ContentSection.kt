package org.adam.resume.website.ui.content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import org.adam.resume.website.SiteEvent
import org.adam.resume.website.SiteState
import org.adam.resume.website.SiteTabs
import org.adam.resume.website.WORD_LIST
import org.adam.resume.website.ui.components.OrbitingWords
import org.adam.resume.website.ui.theme.CurrentColors
import org.adam.resume.website.ui.theme.CurrentTypography

@Composable
fun ContentSection(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CurrentColors.background)
    ) {
        AnimatedContent(
            modifier = Modifier.fillMaxSize(),
            targetState = state.selectedTab,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "FadeScreenTransition"
        ) { tab ->
            key(tab) {
                when (tab) {
                    SiteTabs.ABOUT -> {
                        AboutSection(modifier = Modifier.fillMaxSize(), state = state, onEvent = onEvent)
                    }

                    SiteTabs.SKILLS_AND_TECHNOLOGIES -> {
                        OrbitingWords(
                            modifier = Modifier.fillMaxSize(),
                            words = WORD_LIST,
                            colors = CurrentColors.listColors,
                            textColor = CurrentColors.onSurface,
                        )
                    }

                    SiteTabs.PROJECTS -> {
                        ProjectsSection(state, onEvent)
                    }
                }
            }

        }
    }
}

@Composable
fun ContentSectionPortrait(
    state: SiteState,
    onEvent: (SiteEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CurrentColors.background)
    ) {
        AnimatedContent(
            modifier = Modifier.fillMaxSize(),
            targetState = state.selectedTab,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "FadeScreenTransition"
        ) { tab ->
            key(tab) {
                when (tab) {
                    SiteTabs.ABOUT -> {
                        AboutSectionPortrait(
                            modifier = Modifier.fillMaxSize(),
                            state = state,
                            onEvent = onEvent
                        )
                    }

                    SiteTabs.SKILLS_AND_TECHNOLOGIES -> {
                        OrbitingWords(
                            fontSize = CurrentTypography.body2.fontSize,
                            modifier = Modifier.fillMaxSize(),
                            words = WORD_LIST,
                            colors = CurrentColors.listColors,
                            textColor = CurrentColors.onSurface,
                        )
                    }

                    SiteTabs.PROJECTS -> {
                        ProjectsSection(state, onEvent)
                    }
                }
            }

        }
    }
}