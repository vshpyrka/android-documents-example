package com.example.documents.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.documents.R

class DocumentsAdapter(
    private val dataSet: List<String>,
    private val onClick: (String) -> Unit,
) : RecyclerView.Adapter<DocumentsAdapter.ViewHolder>() {

    class ViewHolder(
        view: View,
        onClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.text)

        init {
            view.setOnClickListener {
                onClick.invoke(bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_document, viewGroup, false),
        ) {
            onClick.invoke(dataSet[it])
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}
