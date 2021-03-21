package com.arifrgilang.ministockbit.ui.watchlist

import android.content.Context
import android.view.ViewGroup
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.ministockbit.R
import com.arifrgilang.ministockbit.base.BaseRecyclerAdapter
import com.arifrgilang.ministockbit.databinding.ItemCryptoBinding
import com.arifrgilang.ministockbit.util.*

class WatchlistRecyclerAdapter constructor(
        context: Context?
) : BaseRecyclerAdapter<CryptoModel, ItemCryptoBinding, WatchlistRecyclerAdapter.ViewHolder>(context) {
    override fun getResLayout(type: Int): Int = R.layout.item_crypto

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistRecyclerAdapter.ViewHolder =
            ViewHolder(initViewBinding(viewType, parent))

    inner class ViewHolder(view: ItemCryptoBinding) : BaseViewHolder(view) {
        override fun onBind(model: CryptoModel) {
            model.raw?.let{ raw ->
                raw.rawDetail?.let{
                    val price = it.price
                    val changePrice = it.changeHour
                    view.cryptocurrency = model
                    view.tvCurrencyPrice.text = formatPrice(price!!)
                    view.tvCurrencyChanges.text = formatCurrencyChanges(model)
                    view.tvCurrencyChanges.changeTextColor(changePrice!!, itemView.context)
                }
            }
        }
    }

    private fun formatCurrencyChanges(model: CryptoModel) : String {
        model.raw?.let{ raw ->
            raw.rawDetail?.let{
                val changePrice = formatPriceChanges(it.changeHour!!).addPrefix()
                val changePricePercentage = formatPriceChangesPercentage(it.changePCTHour!!).addPrefix()
                return "$changePrice (${changePricePercentage}%)"
            }
        }
        return ""
    }
}