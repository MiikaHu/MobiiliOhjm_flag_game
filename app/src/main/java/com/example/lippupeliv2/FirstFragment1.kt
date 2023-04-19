package com.example.lippupeliv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment1 : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Flags>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        imageId = arrayOf(R.drawable.ad, R.drawable.al, R.drawable.ba,R.drawable.be,R.drawable.de,R.drawable.dk,R.drawable.es,R.drawable.fi,R.drawable.fr,R.drawable.gb,R.drawable.it,R.drawable.lt,R.drawable.lu,R.drawable.lv,R.drawable.no,R.drawable.ro,R.drawable.se,R.drawable.sk,R.drawable.tr,R.drawable.ua)

        heading = arrayOf("Andorra","Albania","Bosnia ja Herzegovina","Belgia","Saksa", "Tanska", "Espanja", "Suomi", "Ranska", "Iso-Britannia", "Italia", "Liettua", "Luxemburg", "Latvia", "Norja", "Romania", "Ruotsi", "Slovakia", "Turkki", "Ukraina",)



        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_first1, container, false)
        newRecyclerView=v.findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(getContext())
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Flags>()
        fun getUserdata() {
            for(i in imageId.indices) {
                val flags = Flags(imageId[i],heading[i])
                newArrayList.add(flags)
            }
            newRecyclerView.adapter = MyAdapter(newArrayList)
        }

        val btn = v.findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val secondFragment2 = SecondFragment2()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.mainlayout,secondFragment2)
            transaction.commit()
        }
        getUserdata()
        return v


    }

}