package com.jessebrault.site.composition

import com.jessebrault.ssg.page.Page
import com.jessebrault.ssg.page.PageFactory
import com.jessebrault.ssg.view.WvcCompiler
import groowt.util.di.RegistryObjectFactory
import jakarta.inject.Inject

class CompositionPageFactory implements PageFactory {

    private final RegistryObjectFactory objectFactory
    private final CompositionContainer compositions
    private final WvcCompiler wvcCompiler

    @Inject
    CompositionPageFactory(
            RegistryObjectFactory objectFactory,
            CompositionContainer compositions,
            WvcCompiler wvcCompiler
    ) {
        this.objectFactory = objectFactory
        this.compositions = compositions
        this.wvcCompiler = wvcCompiler
    }

    @Override
    Collection<Page> create() {
        this.compositions.all.collect { composition ->
            new CompositionPageType(
                    name: composition.title,
                    path: "/compositions/$composition.slug",
                    fileExtension: '.html',
                    viewType: CompositionPage,
                    objectFactory: objectFactory,
                    wvcCompiler: wvcCompiler,
                    composition: composition
            )
        }
    }

}
