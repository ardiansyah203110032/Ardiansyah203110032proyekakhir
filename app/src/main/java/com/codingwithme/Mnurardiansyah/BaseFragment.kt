package com.codingwithme.Mnurardiansyah

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
//pada kode program diatas memiliki sebuah Konteks coroutine mencakup dispatcher coroutin yang menentukan utas atau utas apa yang digunakan coroutine terkait untuk eksekusinya. 
//Operator coroutine dapat membatasi eksekusi coroutine ke utas tertentu, mengirimkannya ke kumpulan utas, atau membiarkannya berjalan tanpa batas.
//Semua pembuat coroutine seperti peluncuran dan async menerima parameter CoroutineContext opsional yang dapat digunakan untuk secara eksplisit
//menentukan operator untuk coroutine baru dan elemen konteks lainnya.

abstract class BaseFragment : Fragment(),CoroutineScope{

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job +Dispatchers.Main
//pada kode program tersebut menjelaskan sebuah koneksi yang saling terhung untuk halaman selanjutnya apabila suatu nilai tersebut bernilai benar.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }
//diatas dijelaskan bahsanyaa kode tersebut untuk membuat suatu nilai data yang akan terkoneksi dan ditampilkan ke sebuah ui.
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
//pada sebuah aktifas kode program ini akan memberikan sebuah komentar membatalkan dan mengomentari sebuah activity.
