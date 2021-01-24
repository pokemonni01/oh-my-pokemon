package com.wachi.ohmypokemon.ui.home.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wachi.ohmypokemon.core.BaseViewModel
import com.wachi.ohmypokemon.domain.rssfeed.GetRSSFeedUseCase
import com.wachi.ohmypokemon.domain.rssfeed.RSSFeedModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class HomePokemonNewsFeedViewModel(
    private val getRSSFeedUseCase: GetRSSFeedUseCase
) : BaseViewModel() {

    private val _rssFeedList = MutableLiveData<List<RSSFeedModel>>()
    val rssFeedList: LiveData<List<RSSFeedModel>> = _rssFeedList

    fun getNewsFeed() {
        viewModelScope.launch {
            getRSSFeedUseCase.execute(Unit)
                .flowOn(Dispatchers.IO)
                .onStart { showLoading() }
                .onCompletion { hideLoading() }
                .collect { _rssFeedList.value = it }
        }
    }
}