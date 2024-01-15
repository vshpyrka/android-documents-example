# android-documents-example

[SingleDocumentLauncherActivity](https://github.com/vshpyrka/android-documents-example/blob/main/src/main/java/com/example/documents/single_doc/SingleDocumentLauncherActivity.kt) - serves as a demonstration of launching an independent Android Activity that functions as an opened document, following the style employed by the Google Docs app.

Google Docs app example:


https://github.com/vshpyrka/android-documents-example/assets/2741602/a0a52135-b0d5-4b04-ae1e-47f4b120fbb0

Example:


https://github.com/vshpyrka/android-documents-example/assets/2741602/dd993879-3577-43ed-a760-1b58548ab161

Manifest configuration:

```
<activity
            android:name="com.example.documents.single_doc.DocumentActivity"
            android:autoRemoveFromRecents="true"
            android:documentLaunchMode="intoExisting"
            android:exported="false"
            android:launchMode="standard" />
```

The most important part is the _Intent.data_ configuration, e.g.:

```
data = Uri.parse("content://uniqueId/${docKey.key}")
```
When it's set correctly then Android system handles and opens correct document with specified URI data.

[MultipleDocumentsLauncherActivity](https://github.com/vshpyrka/android-documents-example/blob/main/src/main/java/com/example/documents/multi_instance_doc/MultipleDocumentsLauncherActivity.kt) - show an example of how to open the same document multiple times.

Example:


https://github.com/vshpyrka/android-documents-example/assets/2741602/66d7e69e-c67e-44dd-a0ed-bbf98dbe1bce


More information about launch configuration tags [android:documentLaunchMode](https://developer.android.com/guide/components/activities/recents#attr-doclaunch)
