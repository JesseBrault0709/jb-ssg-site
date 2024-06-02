package com.jessebrault.site.composition

import com.jessebrault.ssg.page.DefaultWvcPage
import com.jessebrault.ssg.util.Diagnostic
import com.jessebrault.ssg.view.PageView
import groowt.util.fp.either.Either

class CompositionPageType extends DefaultWvcPage {

    final Composition composition

    CompositionPageType(Map args) {
        super(args)
        composition = args.composition
    }

    @Override
    Either<Diagnostic, PageView> createView() {
        def result = super.createView()
        if (result.isRight()) {
            def compositionPage = result.getRight() as CompositionPage
            compositionPage.composition = this.composition
        }
        return result
    }

    @Override
    int hashCode() {
        31 * super.hashCode() + composition.hashCode()
    }

    @Override
    boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false
        } else if (obj instanceof CompositionPageType) {
            return composition == obj.composition
        } else {
            return false
        }
    }

    @Override
    String toString() {
        "CompositionPageType($composition)"
    }

}
