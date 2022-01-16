package com.android.androidandjava

class KotlinNoteEntity(title: String, body: String) {

    var title: String = title
        set(value) {
            editData = currentTime
            field = value
        }

    var body: String = title
        set(value) {
            editData = currentTime
            field = value
        }

    var editData: Long = currentTime
        private set

    companion object {
        val currentTime: Long
            get() = 0
    }
}
