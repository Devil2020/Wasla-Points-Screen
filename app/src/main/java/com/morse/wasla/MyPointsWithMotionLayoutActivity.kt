package com.morse.wasla

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morse.wasla.databinding.ActivityMyPointsBinding
import com.morse.wasla.databinding.ActivityMyPointsWithMotionLayoutBinding
import kotlinx.android.synthetic.main.header_layout.view.*

class MyPointsWithMotionLayoutActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyPointsWithMotionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPointsWithMotionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTabs()
        valueAnimate(2510)
        listeners()
    }

    private fun setupTabs() {
        binding.bodyLayout.myPointsTl.addTab(binding.bodyLayout.myPointsTl.newTab().setText("Spend Points"))
        binding.bodyLayout.myPointsTl.addTab(binding.bodyLayout.myPointsTl.newTab().setText("My Activities"))
    }

    private fun valueAnimate(toValue: Int) {
        val valueAnimation = ValueAnimator.ofInt(0, toValue)
        valueAnimation.addUpdateListener {
            binding.headerTitle.total_points_tv.setText(it.getAnimatedValue().toString())
        }
        valueAnimation.setDuration(4000)
        valueAnimation.start()
    }

    private fun listeners() {
        binding.headerTitle.white_iv.apply {
            setOnLongClickListener {
                valueAnimate(5020)
                true
            }

            setOnClickListener {
                valueAnimate(2510)
            }

        }
    }
}