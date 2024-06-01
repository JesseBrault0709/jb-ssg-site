package com.jessebrault.site.composition

import com.jessebrault.ssg.di.InjectTexts
import com.jessebrault.ssg.text.Text
import jakarta.inject.Inject

import java.time.LocalDate

class CompositionContainer {

    private final Set<Composition> compositions

    @Inject
    CompositionContainer(@InjectTexts('/compositions/*.md') Set<Text> compositionTexts) {
        this.compositions = compositionTexts.collect { text ->
            new Composition(
                    text: text,
                    title: text.frontMatter.title,
                    subTitle: text.frontMatter.subTitle,
                    version: text.frontMatter.version,
                    instrumentation: text.frontMatter.instrumentation,
                    shortInfo: text.frontMatter.shortInfo,
                    date: LocalDate.parse(text.frontMatter.date),
                    categories: text.frontMatter.categories as Set<String>
            )
        }
    }

    Set<Composition> getAll() {
        this.compositions
    }

    Set<Composition> getByCategory(String category) {
        this.compositions.findAll { it.categories.contains(category) }
    }

}