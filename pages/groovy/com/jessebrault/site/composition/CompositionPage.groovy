package com.jessebrault.site.composition

import com.jessebrault.site.util.TitleMaker
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
    private final TitleMaker titleMaker
    private final CompositionContainer compositionContainer

    @Inject
    CompositionPage(TitleMaker titleMaker, CompositionContainer compositionContainer) {
        this.titleMaker = titleMaker
        this.compositionContainer = compositionContainer
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
