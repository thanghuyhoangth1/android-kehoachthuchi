package kehoachthuchi.hoang.com.kehoachthuchi.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BaseViewHolder<ItemViewBinding : ViewDataBinding>(val itemViewBinding: ItemViewBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root)