package com.jessebrault.site

import com.jessebrault.site.composition.CompositionContainer
import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.Global
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Compositions', path = '/compositions')
class CompositionsPage extends WvcPageView {

    private final TitleMaker titleMaker
    final CompositionContainer compositions
    final List<String> categories

    @Inject
    CompositionsPage(
            TitleMaker titleMaker,
            CompositionContainer compositions,
            @Global('compositionCategories') List<String> categories
    ) {
        this.titleMaker = titleMaker
        this.compositions = compositions
        this.categories = categories
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
