package com.jessebrault.site

import com.jessebrault.site.composition.Composition
import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.di.InjectTexts
import com.jessebrault.ssg.page.PageSpec
import com.jessebrault.ssg.text.Text
import com.jessebrault.ssg.view.WvcPageView
import jakarta.inject.Inject

@PageSpec(name = 'Compositions', path = '/compositions')
class CompositionsPage extends WvcPageView {

    private final TitleMaker titleMaker
    final Set<Composition> compositions

    @Inject
    CompositionsPage(TitleMaker titleMaker, @InjectTexts('/compositions/*.md') Set<Text> compositions) {
        this.titleMaker = titleMaker
        this.compositions = compositions.collect {
            new Composition(it, it.frontMatter.title)
        }
    }

    String getTitle() {
        titleMaker.makeTitle(pageTitle)
    }

}
