package com.example.kotlin_to_do_list

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_to_do_list.model.Entity
import com.example.kotlin_to_do_list.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var mTodoViewModel: TodoViewModel

    //val binding = ActivityList2Binding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = FragmentListBinding.inflate(layoutInflater)
//        //val binding = TestBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)

        setContentView(R.layout.fragment_list)
        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        val recyclerView = recyclerView
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@ListActivity)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        mTodoViewModel.readAllData.observe(this, Observer { todo ->
            adapter.setData(todo)
        })


        floatingActionBtn.setOnClickListener {
            addTodo()
        }

        floatingDeleteBtn.setOnClickListener {
            deleteAll()
        }
    }

    private fun deleteAll() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.deleteTitle)
        builder.setPositiveButton(R.string.agree) { dialog, which ->
            mTodoViewModel.deleteALLTodo()
            Toast.makeText(this@ListActivity, R.string.sucsesfull_delete,
                Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(R.string.disagree) { dialog, which ->
        }
        builder.show()
    }

    private fun addTodo() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_dashboard, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.task)

        with(builder) {
            setTitle(R.string.add_todo_title)
            setPositiveButton(R.string.agree) { dialog, which ->
                if (editText.text.isNotEmpty()) {
                    val testtt = editText.text.toString()
                    val todo = Entity(0, testtt, "123")
                    mTodoViewModel.addTodo(todo)
                    Toast.makeText(this@ListActivity, R.string.sucsesfull_adding, Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(this@ListActivity, R.string.unsucsesfull_adding,
                        Toast.LENGTH_LONG).show()
                }
            }
            setNegativeButton(R.string.disagree) { dialog, which ->
            }
            setView(dialogLayout)
            show()
        }
    }
}