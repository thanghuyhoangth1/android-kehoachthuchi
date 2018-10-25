package kehoachthuchi.hoang.com.kehoachthuchi.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class BaseRecyclerViewAdapter<ItemViewBinding : ViewDataBinding, Model : BaseModel>(val diffUtil: DiffUtil.ItemCallback<Model>) :
    ListAdapter<Model, BaseViewHolder<ItemViewBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemViewBinding> {
        return createViewHolde().apply {
            bindFirstTime(this.itemViewBinding)
        }
    }

    abstract fun bindFirstTime(itemViewBinding: ItemViewBinding)

    abstract fun createViewHolde(): BaseViewHolder<ItemViewBinding>

    override fun onBindViewHolder(holder: BaseViewHolder<ItemViewBinding>, position: Int) {
        bindData(holder.itemViewBinding, getItem(position))
        holder.itemViewBinding.executePendingBindings()

    }

    abstract fun bindData(itemViewBinding: ViewDataBinding, item: BaseModel)
}