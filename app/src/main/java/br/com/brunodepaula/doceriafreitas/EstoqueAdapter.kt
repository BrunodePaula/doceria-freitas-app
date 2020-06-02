package br.com.brunodepaula.doceriafreitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class EstoqueAdapter (
    val estoque: List<Estoque>,
    val onClick: (Estoque) -> Unit): RecyclerView.Adapter<EstoqueAdapter.EstoqueViewHolder>(){

    class EstoqueViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        /*val cardImage: ImageView
        val cardProgress: ProgressBar*/
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.cardNome)
            /* cardImage = view.findViewById(R.id.cardImage)
             cardProgress = view.findViewById(R.id.cardProgress)*/
            cardView = view.findViewById(R.id.card_estoque)
        }
    }

    override fun getItemCount() = this.estoque.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstoqueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_estoque, parent, false)

        val holder = EstoqueViewHolder(view)
        return  holder
    }

    override fun onBindViewHolder(holder: EstoqueViewHolder, position: Int) {
        val context = holder.itemView.context

        val estoque =  estoque[position]

        holder.cardNome.text = estoque.name
//        holder.cardProgress.visibility = View.VISIBLE

        //Picasso.with(context).load(clientes.url).fit().into(
        //   holder.cardImage,
        //  object: com.squareup.picasso.Callback {
        //      override fun onSuccess() {
        //          holder.cardProgress.visibility = View.GONE
        //      }

        //      override fun onError() {
        //          holder.cardProgress.visibility = View.GONE
        //      }
        //  }
        //)

        holder.itemView.setOnClickListener { onClick(estoque) }
    }
}