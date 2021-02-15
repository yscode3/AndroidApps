package pleasand.j.aboutscrolling

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TheListAdapter : RecyclerView.Adapter<TheListAdapter.ViewHolder>() {
    val data = ArrayList<TheListData>()

    fun addProfile(data:TheListData) {
        this.data.add(data)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var profileImg:ImageView
        var profileName:TextView
        var profileMsg:TextView

        init {
            profileImg = item.findViewById(R.id.profileImg)
            profileName = item.findViewById(R.id.profileName)
            profileMsg = item.findViewById(R.id.profileMsg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.thelist_itemview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TheListAdapter.ViewHolder, position: Int) {
        val name = holder.profileName
        val img = holder.profileImg
        val msg = holder.profileMsg

        val theInfo = data.get(position)

        name.text = theInfo.profileName
        img.setImageResource(theInfo.profileImg)
        msg.text = theInfo.profileMsg

    }

    override fun getItemCount(): Int = data.size
}