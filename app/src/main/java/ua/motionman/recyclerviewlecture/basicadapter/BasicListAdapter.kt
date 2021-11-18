package ua.motionman.recyclerviewlecture.basicadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ua.motionman.recyclerviewlecture.databinding.BasicItemBinding
import ua.motionman.recyclerviewlecture.model.Comment

class BasicListAdapter : ListAdapter<Comment, BasicListAdapter.BasicViewHolder>(diff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        val binding = BasicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return if (currentList.size > 5) {
            5
        } else {
            currentList.size
        }
    }

    inner class BasicViewHolder(private val binding: BasicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Comment) {
            with(binding) {
                userNameTextView.text = item.email
            }
        }
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.email == newItem.email &&
                        oldItem.body == newItem.body
            }
        }
    }

}