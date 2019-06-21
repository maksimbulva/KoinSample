package com.example.koinsample.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.koinsample.Foo
import com.example.koinsample.R.id
import com.example.koinsample.R.layout
import com.example.koinsample.Repository
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // "Field injection". inject() works lazy, for eager initialization there is get() function
    private val repository: Repository by inject()

    // ViewModel injection. If activity will be re-created, same instance will be provided
    private val viewModel: MainActivityViewModel by viewModel()

    // Injection of "scoped" objects.
    // For Activity "currentScope" property creates new scope (or returns already created) and bound it to
    // Lifecycle events: scope will be deleted on ON_DESTROY event.
    private val presenter: MainActivityPresenter by currentScope.inject()

    private val foo: Foo by inject()

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)

        textView = findViewById(id.text)
        viewModel.greetings.observe(this, Observer { textView.text = it })

        findViewById<Button>(id.toggle_fragment_button).setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(id.fragment_host)
            if (fragment == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(id.fragment_host, ExampleFragment())
                    .commitNow()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .remove(fragment)
                    .commitNow()
            }
        }

        Log.d("MyTest", foo.toString())
    }
}
