package com.jessebrault.site

import com.jessebrault.site.composition.Composition
import groowt.view.component.web.BaseWebViewComponent

class CompositionCategory extends BaseWebViewComponent {

    final String category
    private final Set<Composition> compositions

    CompositionCategory(Map attr) {
        this.category = attr.category
        this.compositions = attr.compositions
    }

    List<Composition> getCompositions() {
        this.compositions.sort { c0, c1 ->
            c1.date <=> c0.date
        }
    }

}
