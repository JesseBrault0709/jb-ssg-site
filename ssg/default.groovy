import com.jessebrault.site.composition.CompositionContainer
import com.jessebrault.site.util.TitleMaker
import com.jessebrault.ssg.buildscript.BuildScriptBase
import groovy.transform.BaseScript

import static groowt.util.di.BindingUtil.toSelf

@BaseScript
BuildScriptBase base

build {
    siteName 'Jesse Brault'
    baseUrl 'https://jessebrault.com'
    basePackage 'com.jessebrault.site'
    globals {
        siteTagLine = 'Conductor, Composer, Developer'
        menuItems = ['Biography', 'Compositions', 'Videos', 'Lessons', 'Résumé', 'Developer', 'Contact']
        compositionCategories = ['Orchestra', 'Chamber', 'Solo', 'Wind Ensemble']
        spotifyUrl = 'https://open.spotify.com/artist/4ea1gZnLlQTrXKIMsnlr45?si=DfR-KCDyTiycbjmYwu566w'
        youtubeUrl = 'https://www.youtube.com/@JesseBrault0709'
        linkedInUrl = 'https://www.linkedin.com/in/jessebrault0709/'
        githubUrl = 'https://github.com/JesseBrault0709'
        openGraphFallbackImage = 'https://jessebrault.nyc3.cdn.digitaloceanspaces.com/images/portrait3.jpg'
    }
    objectFactoryBuilder.configure {
        configureRegistry {
            bind(TitleMaker, toSelf())
            bind(CompositionContainer, toSelf())
        }
    }
}
