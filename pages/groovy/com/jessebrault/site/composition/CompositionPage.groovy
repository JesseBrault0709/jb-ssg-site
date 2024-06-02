package com.jessebrault.site.composition

import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

import java.time.format.DateTimeFormatter

class CompositionPage extends WvcPageView {

    Composition composition
    private final TitleMaker titleMaker

    @Inject
    CompositionPage(TitleMaker titleMaker) {
        this.titleMaker = titleMaker
    }

    String getTitle() {
        this.titleMaker.makeTitle(pageTitle)
    }

    String getCompositionYear() {
        composition.date.format(DateTimeFormatter.ofPattern('yyyy'))
    }

}
