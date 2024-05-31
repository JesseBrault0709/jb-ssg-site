package com.jessebrault.site

import com.jessebrault.ssg.di.Global
import com.jessebrault.ssg.di.InjectPages
import com.jessebrault.ssg.page.Page
import groowt.view.component.web.BaseWebViewComponent
import jakarta.inject.Inject
import jakarta.inject.Named

class Header extends BaseWebViewComponent {

    final String siteName
    final String siteTagLine
    final List<Page> menuItems

    @Inject
    Header(
            @Named('siteName') String siteName,
            @Global('siteTagLine') String siteTagLine,
            @Global('menuItems') List<String> menuItems,
            @InjectPages('/*') Set<Page> allPages
    ) {
        this.siteName = siteName
        this.siteTagLine = siteTagLine
        this.menuItems = menuItems.collect { menuItem ->
            allPages.find { it.name == menuItem }
        }
    }

}
