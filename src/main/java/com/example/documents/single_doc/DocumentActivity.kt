package com.example.documents.single_doc

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.core.view.isVisible
import com.example.documents.databinding.ActivitySingleDocumentBinding
import com.example.documents.utils.documents

class DocumentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleDocumentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleDocumentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val docKey = intent.data?.lastPathSegment
        title = documents[docKey]

        val activityManager = getSystemService<ActivityManager>()
        val appTasks = activityManager?.appTasks

        val tasks = "Tasks in stack: ${appTasks?.size}"
        binding.tasks.text = tasks
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        binding.status.text = "Document opened again"
        binding.status.isVisible = true
    }
}
