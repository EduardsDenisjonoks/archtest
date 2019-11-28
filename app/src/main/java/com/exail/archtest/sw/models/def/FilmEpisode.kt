package com.exail.archtest.sw.models.def

import androidx.annotation.IntDef
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_FIVE
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_FOUR
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_ONE
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_SEVEN
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_SIX
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_THREE
import com.exail.archtest.sw.models.def.FilmEpisode.Companion.EPISODE_TWO

@Retention(AnnotationRetention.SOURCE)
@IntDef(
    EPISODE_ONE,
    EPISODE_TWO,
    EPISODE_THREE,
    EPISODE_FOUR,
    EPISODE_FIVE,
    EPISODE_SIX,
    EPISODE_SEVEN
)
annotation class FilmEpisode {

    companion object {
        const val EPISODE_ONE: Int = 1
        const val EPISODE_TWO: Int = 2
        const val EPISODE_THREE: Int = 3
        const val EPISODE_FOUR: Int = 4
        const val EPISODE_FIVE: Int = 5
        const val EPISODE_SIX: Int = 6
        const val EPISODE_SEVEN: Int = 7
    }

}