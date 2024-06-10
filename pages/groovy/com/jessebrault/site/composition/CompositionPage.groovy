package com.jessebrault.site.composition

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.SelfPage
import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.view.WvcPageView
import groovy.transform.Canonical
import jakarta.inject.Inject

import java.time.format.DateTimeFormatter

class CompositionPage extends WvcPageView {

    @Canonical
    static class AlternateVersion {
        final String versionName
        final String path
    }

    Composition composition
    final Page selfPage

    private final TitleMaker titleMaker
    private final CompositionContainer compositionContainer

    @Inject
    CompositionPage(TitleMaker titleMaker, CompositionContainer compositionContainer, @SelfPage Page selfPage) {
        this.titleMaker = titleMaker
        this.compositionContainer = compositionContainer
        this.selfPage = selfPage
    }

    String getTitle() {
        this.titleMaker.makeTitle(pageTitle)
    }

    String getCompositionYear() {
        composition.date.format(DateTimeFormatter.ofPattern('yyyy'))
    }

    Set<AlternateVersion> getAlternateVersions() {
        compositionContainer.getAlternateVersions(composition).collect {
            new AlternateVersion(it.version, "/compositions/${it.slug}")
        }
    }

}
