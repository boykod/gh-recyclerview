package ua.motionman.recyclerviewlecture.basicadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.motionman.recyclerviewlecture.databinding.BasicItemBinding
import ua.motionman.recyclerviewlecture.model.Comment

interface OnItemClick {
    fun onPress(item: Comment)
}

class BasicRecyclerAdapter(
    val listener: OnItemClick
) : RecyclerView.Adapter<BasicRecyclerAdapter.BasicRecyclerViewHolder>() {

    var comments: List<Comment> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicRecyclerViewHolder {
        val binding = BasicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasicRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasicRecyclerViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount() = comments.size

    inner class BasicRecyclerViewHolder(private val binding: BasicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Comment) {
            with(binding) {
                userNameTextView.text = item.email
                itemContainer.setOnClickListener {
                    listener.onPress(item)
                }
            }
        }
    }

}