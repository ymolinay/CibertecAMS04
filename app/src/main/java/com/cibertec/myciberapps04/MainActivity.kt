package com.cibertec.myciberapps04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibertec.myciberapps04.databinding.ActivityMainBinding
import com.cibertec.myciberapps04.databinding.ItemTourismBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var adapter: TourismPlaceAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcListPLaces.layoutManager = LinearLayoutManager(this)
        fetchTourismPlace()
    }

    private fun fetchTourismPlace() {
        ClientInstance.api.getAllTourismPLaces()
            .enqueue(object : Callback< List<TourismPlace> > {
                override fun onResponse(
                    call: Call<List<TourismPlace>>,
                    response: Response<List<TourismPlace>>
                ) {
                    if (response.isSuccessful) {
                        val listPLaces = response.body() ?: emptyList()
                        adapter = TourismPlaceAdapter(listPLaces)
                        binding.rcListPLaces.adapter = adapter

                    } else {
                        // error controlado
                        showError("Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<TourismPlace>>, t: Throwable) {
                    // error no controlado
                    showError("Error: ${t.message}")
                }

            })

    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}