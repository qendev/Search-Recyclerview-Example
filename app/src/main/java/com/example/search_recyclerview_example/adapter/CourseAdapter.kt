package com.example.search_recyclerview_example.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.search_recyclerview_example.databinding.CourseItemBinding
import com.example.search_recyclerview_example.model.Course

class CourseAdapter(private var courseList:ArrayList<Course>):RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int,): CourseAdapter.CourseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CourseItemBinding.inflate(inflater,parent,false)
        return  CourseViewHolder(binding)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterList:ArrayList<Course>){
        // below line is to add our filtered
        // list in our course array list.
        courseList = filterList
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()

    }




    override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.view.imageViewCourse.setImageResource(course.courseImg)
        holder.view.textViewCourse.text = course.courseName
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class CourseViewHolder(val view: CourseItemBinding):RecyclerView.ViewHolder(view.root)


}