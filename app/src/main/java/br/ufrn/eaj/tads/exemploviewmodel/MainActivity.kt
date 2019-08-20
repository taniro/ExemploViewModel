package br.ufrn.eaj.tads.exemploviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val vm : ContViewModel by lazy {
        ViewModelProviders.of(this)[ContViewModel::class.java]
    }


    private val ob1 = Observer<Int> {
        atualizaUI(it?:0)
    }

    private val ob2 = Observer<Int> {
        value -> value?.let { atualizaUI(value) }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val vm = ViewModelProviders.of(this)[ContViewModel::class.java]

        vm.notificadorCont.observe(this, ob1)

        vm.notificadorCont.observe(this, Observer { atualizaUI(it?:0) })

        /*
        contTextView.setOnClickListener {
            vm.incrementa()
            contTextView.text = "${vm.cont}"
        }
        */

        contTextView.setOnClickListener { vm.incrementa() }



        /*
        var cont = 0;
        contTextView.text = "$cont"

        contTextView.setOnClickListener {
            cont++;
            contTextView.text = "$cont"
        }
        */
    }

    private fun atualizaUI(value: Int) {
        contTextView.text = "$value"
    }
}
