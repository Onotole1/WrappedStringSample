package com.example.wrappedstringsample

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView : MvpView {
    @StateStrategyType(SingleStateStrategy::class)
    fun setState(state: MainScreenState)
}