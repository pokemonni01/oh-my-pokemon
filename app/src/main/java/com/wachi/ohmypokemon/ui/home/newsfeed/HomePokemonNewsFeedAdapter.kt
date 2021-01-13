package com.wachi.ohmypokemon.ui.home.newsfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.domain.rssfeed.RSSFeedModel
import kotlinx.android.synthetic.main.item_pokemon_news_feed.view.*

class HomePokemonNewsFeedAdapter(
    private val newsFeedItemList: ArrayList<RSSFeedModel>,
    private val onItemSelect: (RSSFeedModel) -> Unit
) : RecyclerView.Adapter<HomePokemonNewsFeedItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePokemonNewsFeedItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_pokemon_news_feed,
            parent, false
        )
        return HomePokemonNewsFeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomePokemonNewsFeedItemViewHolder, position: Int) {
        val item = newsFeedItemList[position]
        holder.setViewData(item)
        holder.itemView.setOnClickListener {
            onItemSelect(item)
        }
    }

    override fun getItemCount() = newsFeedItemList.size

    fun onUpdateItem(list: ArrayList<RSSFeedModel>) {
        newsFeedItemList.clear()
        newsFeedItemList.addAll(list)
        notifyDataSetChanged()
    }
}

class HomePokemonNewsFeedItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setViewData(item: RSSFeedModel) {
        Glide.with(view)
            .load(item.imageUrl)
            .into(view.ivNewsImage)
        view.tvNewsDate.text = item.pubDate
        view.tvNewsAuthor.text = item.author
        view.tvNewsTitle.text = item.title
        view.tvNewsMessage.text = item.description
    }
}