package com.irfan.challengech5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import challengech5.databinding.ItemRecycleviewBinding
import com.irfan.challengech5.model.GetAllCarResponseItem
import com.bumptech.glide.Glide

class MainAdapter(
    private val item: List<GetAllCarResponseItem>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    class MainViewHolder(val binding: ItemRecycleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.tvNama.text = item[position].name
        holder.binding.tvPrice.text = item[position].price.toString()


        Glide.with(holder.itemView.context)
            .load(item[position].image)
            .into(holder.binding.ivImage)

//        holder.itemView.setOnClickListener {
//            var name = item[position].name
//            var price = item[position].price
//            var detail = DetailModel(
//                name,detail
//            )
//            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(name,price))
//        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}