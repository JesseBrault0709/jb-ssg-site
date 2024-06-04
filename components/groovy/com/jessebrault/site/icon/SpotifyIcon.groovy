package com.jessebrault.site.icon

import com.jessebrault.ssg.view.SkipTemplate
import groowt.view.View
import groowt.view.component.web.lib.DelegatingWebViewComponent

@SkipTemplate
class SpotifyIcon extends DelegatingWebViewComponent {

    private static final String svgText = SpotifyIcon.getResource('Spotify.txt').text

    @Override
    protected View getDelegate() {
        return { Writer w ->
            w << svgText
        }
    }

}
