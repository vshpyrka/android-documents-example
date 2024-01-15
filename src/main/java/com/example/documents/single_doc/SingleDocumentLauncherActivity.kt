package com.example.documents.single_doc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.documents.databinding.ActivitySingleDocumentLauncherBinding
import com.example.documents.utils.DocumentsAdapter
import com.example.documents.utils.documents

class SingleDocumentLauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingleDocumentLauncherBinding.inflate(layoutInflater)
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

                    data = Uri.parse("content://uniqueId/${docKey.key}")
                }
        )
    }
}
