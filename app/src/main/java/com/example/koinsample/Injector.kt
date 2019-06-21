package com.example.koinsample

import com.example.koinsample.ui.ExampleFragmentViewModel
import com.example.koinsample.ui.MainActivity
import com.example.koinsample.ui.MainActivityPresenter
import com.example.koinsample.ui.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun initInjector() {

    val appModule = module {

        // will be only one instance of RepositoryImpl()
        single<Repository> { RepositoryImpl(get()) }

        // new instance will be created for each request (not necessary, just for this example)
        factory<WebService> { WebServiceImpl() }

        single<Foo> { FooImpl(get()) }
        single<Bar> { BarImpl(get()) }
    }

    val mainActivityModule = module {

        // no need to implement ViewModelFactory
        // dependencies from other modules can be accessed
        viewModel { MainActivityViewModel(get()) }
        viewModel { ExampleFragmentViewModel(get()) }

        // "Named scope"
        scope(named<MainActivity>()) {
            // will be only one instance within scope instance
            scoped { MainActivityPresenter(get()) }
        }
    }

    startKoin {
        // modules could be loaded (and unloaded) later
        modules(listOf(appModule, mainActivityModule))
    }
}