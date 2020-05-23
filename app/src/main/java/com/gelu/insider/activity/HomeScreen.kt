package com.gelu.insider.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gelu.insider.R
import com.gelu.insider.adapter.EventAdapter
import com.gelu.insider.model.event.EventModel
import com.gelu.insider.model.event.EventTypeModel
import com.gelu.insider.service.ServiceGenerator
import com.gelu.insider.utility.ConnectionDetector
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_home_screen.*
import org.json.JSONObject
import retrofit2.Response

class HomeScreen : AppCompatActivity() {

    lateinit var eventTypeList: ArrayList<EventTypeModel>
    lateinit var popularEventList: ArrayList<EventModel>
    lateinit var featuredEventList: ArrayList<EventModel>
    lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        initUI()
        callEventAPI(1, "go-out", "mumbai")
    }

    private fun initUI() {
        eventTypeList = ArrayList()
        popularEventList = ArrayList()
        featuredEventList = ArrayList()
        eventAdapter = EventAdapter(this@HomeScreen, eventTypeList)
        rvEvents.layoutManager =
            LinearLayoutManager(this@HomeScreen, LinearLayoutManager.VERTICAL, false)
        rvEvents.adapter = eventAdapter

        if(!ConnectionDetector.isConnectedToInternet(this@HomeScreen)){
            progressBar.visibility=View.GONE
        }
    }

    private fun callEventAPI(i: Int, filterBy: String, city: String) {

        ServiceGenerator(this, object : ServiceGenerator.ServiceGeneratorInterfaceWithFailure {

            override fun OnSuccess(response: Response<JsonObject?>) {
                try {
                    if (response.isSuccessful) {
                        progressBar.visibility=View.GONE
                        popularEventList.addAll(
                            Gson().fromJson(
                                JSONObject(
                                    response.body().toString()
                                ).getJSONArray("popular").toString(),
                                object : TypeToken<ArrayList<EventModel>>() {}.type
                            )
                        )

                        featuredEventList.addAll(
                            Gson().fromJson(
                                JSONObject(
                                    response.body().toString()
                                ).getJSONArray("featured").toString(),
                                object : TypeToken<ArrayList<EventModel>>() {}.type
                            )
                        )

                        eventTypeList.add(EventTypeModel("Popular Event", popularEventList))
                        eventTypeList.add(EventTypeModel("Featured Event", featuredEventList))

                        eventAdapter.notifyDataSetChanged()

                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun OnFailure(call1: Throwable) {
                progressBar.visibility=View.GONE
                Toast.makeText(this@HomeScreen, call1.message, Toast.LENGTH_SHORT).show()
            }
        }, ServiceGenerator.createAPI(this).getEvent(i, filterBy, city))
    }
}
