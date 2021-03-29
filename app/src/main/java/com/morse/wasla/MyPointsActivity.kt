package com.morse.wasla

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morse.wasla.databinding.ActivityMyPointsBinding

class MyPointsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTabs()
        valueAnimate(2510)
        listeners ()
    }

    private fun setupTabs() {
        binding.myPointsTl.addTab(binding.myPointsTl.newTab().setText("Spend Points"))
        binding.myPointsTl.addTab(binding.myPointsTl.newTab().setText("My Activities"))
    }

    private fun valueAnimate(toValue: Int) {
        val valueAnimation = ValueAnimator.ofInt(0, toValue)
        valueAnimation.addUpdateListener {
            binding.totalPointsTv.setText(it.getAnimatedValue().toString())
        }
        valueAnimation.setDuration(4000)
        valueAnimation.start()
    }

    private fun listeners () {
        binding.whiteIv.apply {
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