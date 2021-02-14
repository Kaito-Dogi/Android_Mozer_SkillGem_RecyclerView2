package app.doggy.skillgem_recyclerview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    val items: MutableList<Task> = mutableListOf()

    //importする。
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_task_data_cell, parent, false)
        return ViewHolder(view)
    }

    //importする。
    //itemsのposition番目の要素をViewHolderに表示する。
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.dateTextView.text = item.createdAt.toString()
        holder.checkBox.isChecked = false
    }

    //importする。
    override fun getItemCount(): Int {
        return items.size
    }

    //Adapterにデータを登録するためのメソッド。
    fun addAll(items: List<Task>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    //複数のViewを保持するクラス。
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }
}