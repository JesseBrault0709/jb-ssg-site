package com.jessebrault.site

import com.jessebrault.site.composition.Composition
import groowt.view.component.web.BaseWebViewComponent

class CompositionListing extends BaseWebViewComponent {

    final Composition composition

    CompositionListing(Composition composition) {
        this.composition = composition
    }

}
