package com.codingwithme.Mnurardiansyah
//Nama file package dari proyek android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codingwithme.notesapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//pada kode program diatas yaitu untuk memulai suatu aktifitas lain pada sebuah halaman yang telah dibuat dan akan keluar bernilai salah apalabila tidak sesuai
        replaceFragment(HomeFragment.newInstance(),false)

    }


    fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()
//pada kode tersebut yaitu membuat subclass yang memiliki fungsi yang sama seperti Activity,dan juga dijelaskan akan memuat dan memanggil sebuah fragmen
//memiliki sebuah nilai apabila hasil yang dikembalikan bisa berupa null jika fragmen tidak menyediakan UI atau tampilan.

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.add(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
//pada kode program tersebut akan dijalankan apabila nilai tersebut benar dan  dapat memuat sebuah transisi pada halaman desain, efek ini akan dijalankan
//ketika fragment di load dan diimplementasikan pada fragmant yang diload yang di replace

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments
        if (fragments.size == 0){
            finish()
        }
    }
}
//pada kode program tersebut sebuah fragmen seharusnya tidak tahu atau peduli tentang tombol BACK. Suatu aktivitas dapat memperhatikan tombol BACK.
//meskipun dengan fragmen yang biasanya ditangani oleh FragmentManager. Tetapi karena fragmen tidak mengetahui tentang lingkungannya yang lebih besar.
