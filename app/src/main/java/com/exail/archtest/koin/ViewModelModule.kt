package com.exail.archtest.koin

import com.exail.archtest.cats.view.models.CatPaginatedViewModel
import com.exail.archtest.cats.view.models.CatViewModel
import com.exail.archtest.chuck.norris.view.model.ChuckNorrisViewModel
import com.exail.archtest.notifictions.view.model.NotificationViewModel
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.models.People
import com.exail.archtest.sw.view.model.FilmViewModel
import com.exail.archtest.sw.view.model.FilmsViewModel
import com.exail.archtest.sw.view.model.PeopleViewModel
import com.exail.archtest.sw.view.model.PersonViewModel
import com.exail.archtest.test.view.model.TestGroundViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CatViewModel(catRepository = get()) }
    viewModel { CatPaginatedViewModel(catRepository = get()) }
    viewModel { ChuckNorrisViewModel(chuckNorrisRepository = get()) }
    viewModel { TestGroundViewModel() }
    viewModel { PeopleViewModel(starWarsRepository = get()) }
    viewModel { FilmsViewModel(starWarsRepository = get()) }
    viewModel { (film : Film?) -> FilmViewModel(film) }
    viewModel { (person: People?) -> PersonViewModel(person = person, startWarsRepository = get()) }
    viewModel { NotificationViewModel() }

}