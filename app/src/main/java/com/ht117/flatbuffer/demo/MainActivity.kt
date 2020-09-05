package com.ht117.flatbuffer.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.ht117.flatbuffer.model.People
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.nio.ByteBuffer

data class People(val id: String,
                  val name: String,
                  val year_old: Int,
                  val address: Address,
                  val contact: Contact, val relatives: List<People>)

data class Address(val street: String,
                   val district: String,
                   val city: String)

data class Contact(val phone: String, val email: String)

class MainActivity : AppCompatActivity() {
    @ExperimentalUnsignedTypes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJson.setOnClickListener {
            loadJson()
        }

        btnBuffer.setOnClickListener {
            loadBuffer()
        }
    }

    private fun loadJson() {
        tvStatus.text = "Loading... json"
        tvData.text = ""
        val startTime = System.currentTimeMillis()
        val input = resources.openRawResource(R.raw.people_json)
        val sb = StringBuilder()
        val br = BufferedReader(InputStreamReader(input, "UTF-8"))
        var line: String?

        while (true) {
            line = br.readLine()
            if (line != null) {
                sb.append(line)
            } else {
                break
            }
        }
        Log.d("Debug", "Json $sb")
        val data = Gson().fromJson(sb.toString().trim(), com.ht117.flatbuffer.demo.People::class.java)

        val duration = System.currentTimeMillis() - startTime
        tvStatus.text = "Loaded in $duration ms"
        tvData.text = """
            id: ${data.id}
            name: ${data.name}
            contact: ${data.contact?.email} - ${data.contact?.phone}
            address: ${data.address?.city} - ${data.address?.district} - ${data.address?.street}
        """.trimIndent()
    }

    @ExperimentalUnsignedTypes
    private fun loadBuffer() {
        tvStatus.text = "Loading... buffer"
        tvData.text = ""
        val startTime = System.currentTimeMillis()
        val bufferStream = resources.openRawResource(R.raw.people_binary)
        val array = convertToByteBuffer(bufferStream)
        val data = People.getRootAsPeople(array)

        val duration = System.currentTimeMillis() - startTime
        Log.d("Debug", " $duration\n $data")
        tvStatus.text = "Loaded in $duration ms"
        tvData.text = """
            id: ${data.id}
            name: ${data.name}
            contact: ${data.contact?.email} - ${data.contact?.phone}
            address: ${data.address?.city} - ${data.address?.district} - ${data.address?.street}
        """.trimIndent()
    }

    private fun convertToByteBuffer(inputStream: InputStream): ByteBuffer {
        val baos = ByteArrayOutputStream()
        val buff = ByteArray(inputStream.available())
        var i = inputStream.read(buff, 0, buff.size)
        while (i > 0) {
            baos.write(buff, 0, i)
            i = inputStream.read(buff, 0, buff.size)
        }
        return ByteBuffer.wrap(baos.toByteArray())
    }
}
