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

class ClientesAdapter (
    val clientes: List<Clientes>,
    val onClick: (Clientes) -> Unit): RecyclerView.Adapter<ClientesAdapter.ClientesViewHolder>(){

    class ClientesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.cardNome)
            cardImage = view.findViewById(R.id.cardImage)
            cardProgress = view.findViewById(R.id.cardProgress)
            cardView = view.findViewById(R.id.card_clientes)
        }
    }

    override fun getItemCount() = this.clientes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_clientes, parent, false)

        val holder = ClientesViewHolder(view)
        return  holder
    }

    override fun onBindViewHolder(holder: ClientesViewHolder, position: Int) {
        val context = holder.itemView.context

        val clientes =  clientes[position]

        holder.cardNome.text = clientes.name
        holder.cardProgress.visibility = View.VISIBLE

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

        holder.itemView.setOnClickListener { onClick(clientes) }
    }
}