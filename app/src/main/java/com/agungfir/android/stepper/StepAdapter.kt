package com.agungfir.android.stepper

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.agungfir.android.R

class StepAdapter(val context: Context) : RecyclerView.Adapter<StepAdapter.ViewHolder>() {


    private val steps = context.resources.getStringArray(R.array.steps)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(step: String) {
//            val spanned: Spanned = Html.fromHtml(step)
            val spanned: Spanned = HtmlCompat.fromHtml(step, HtmlCompat.FROM_HTML_MODE_LEGACY)
            itemView.findViewById<TextView>(R.id.tv_step).text = spanned
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stepper, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(steps[position])
        holder.itemView.findViewById<TextView>(R.id.tv_number_step).text = (position + 1).toString()
        if (position == 0) {
            holder.itemView.findViewById<View>(R.id.view_stepper_up).visibility = View.INVISIBLE
        }
        if (position == steps.size - 1) {
            holder.itemView.findViewById<View>(R.id.view_stepper_down).visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = steps.size
}