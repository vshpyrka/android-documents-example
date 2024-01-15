package com.example.documents.multi_instance_doc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.documents.databinding.ActivityMultipleDocumentsLauncherBinding
import com.example.documents.utils.DocumentsAdapter
import com.example.documents.utils.documents

class MultipleDocumentsLauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMultipleDocumentsLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Documents"

        binding.list.adapter = DocumentsAdapter(documents.values.toList(), ::handleDocumentClick)
        binding.list.layoutManager = GridLayoutManager(this, 2)
    }

    private fun handleDocumentClick(document: String) {
        startActivity(
            Intent(this, DocumentActivity::class.java)
                .apply {
                    val docKey = documents.entries.first { it.value == document }

                    addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
                    addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

                    data = Uri.parse("content://uniqueId/${docKey.key}")
                }
        )
    }
}
