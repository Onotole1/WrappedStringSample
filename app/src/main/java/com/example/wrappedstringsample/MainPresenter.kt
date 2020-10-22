package com.example.wrappedstringsample

import moxy.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        val wrappedString = WrappedString.Resource(R.string.sample_text)
        viewState.setState(
            MainScreenState(
                // Контент пересоздаётся при любой смене конфигурации
                wrappedString = wrappedString,
                // Контент пересоздаётся при закрытии приложения или уходе с экрана
                string = wrappedString.toString(App.INSTANCE)
            )
        )
    }
}