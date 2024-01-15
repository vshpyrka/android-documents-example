package com.example.documents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.documents.databinding.ActivityDocumentsLauncherBinding
import com.example.documents.multi_instance_doc.MultipleDocumentsLauncherActivity
import com.example.documents.single_doc.SingleDocumentLauncherActivity

class DocumentsLauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = this::class.java.simpleName
        val binding = ActivityDocumentsLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newDocument.setOnClickListener {
            startActivity(Intent(this, SingleDocumentLauncherActivity::class.java))
        }
        binding.multipleDocuments.setOnClickListener {
            startActivity(Intent(this, MultipleDocumentsLauncherActivity::class.java))
        }
    }
}
