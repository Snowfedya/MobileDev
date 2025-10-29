package com.example.restaurantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DishDetailFragment : Fragment() {

    private lateinit var dish: Dish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dish = it.getParcelable(ARG_DISH)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dish_detail, container, false)

        val dishImageView = view.findViewById<ImageView>(R.id.dishImageView)
        val dishNameTextView = view.findViewById<TextView>(R.id.dishNameTextView)
        val dishDescriptionTextView = view.findViewById<TextView>(R.id.dishDescriptionTextView)

        dishImageView.setImageResource(dish.imageResource)
        dishNameTextView.text = dish.name
        dishDescriptionTextView.text = dish.description

        return view
    }

    companion object {
        private const val ARG_DISH = "dish"

        fun newInstance(dish: Dish): DishDetailFragment {
            val fragment = DishDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_DISH, dish)
            fragment.arguments = args
            return fragment
        }
    }
}
