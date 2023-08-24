package com.example.tugaseureka.view
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaseureka.R
import com.example.tugaseureka.api.ApiClient
import com.example.tugaseureka.api.ApiResponse
import com.example.tugaseureka.model.UserModel
import com.example.tugaseureka.viewModel.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarPengguna : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = ApiClient.apiService

        val recyclerView: RecyclerView = view.findViewById(R.id.userRecyclerView)

        val call: Call<ApiResponse<UserModel>> = apiService.getUsers()
        call.enqueue(object : Callback<ApiResponse<UserModel>> {
            override fun onResponse(call: Call<ApiResponse<UserModel>>, response: Response<ApiResponse<UserModel>>) {
                if (response.isSuccessful) {
                    val userResponse: ApiResponse<UserModel>? = response.body()
                    val users: List<UserModel>? = userResponse?.data

                    // Lakukan sesuatu dengan daftar users
                    val userAdapter = UserAdapter(users ?: emptyList())
                    recyclerView.adapter = userAdapter

                    recyclerView.layoutManager = LinearLayoutManager(requireContext())

                } else {
                    // Tangani respon yang tidak berhasil
                    val errorBody = response.errorBody()?.string()
                    Log.e("API Error", "Response Error Body: $errorBody")

                    // Tampilkan pesan kesalahan kepada pengguna
                    val errorMessage = "Failed to fetch data"
                }
            }

            override fun onFailure(call: Call<ApiResponse<UserModel>>, t: Throwable) {
                // Tangani kesalahan
                Log.e("API Error", "Network Error: ${t.message}")

                // Tampilkan pesan kesalahan kepada pengguna
                val errorMessage = "Network error occurred"

            }
        })
    }
}
