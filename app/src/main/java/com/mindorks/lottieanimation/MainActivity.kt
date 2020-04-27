package com.mindorks.lottieanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.lav_click_left
import kotlinx.android.synthetic.main.activity_main.lav_click_right
import kotlinx.android.synthetic.main.activity_main.lav_main
import kotlinx.android.synthetic.main.activity_main.tv_headline

class MainActivity : AppCompatActivity() {

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        lav_click_right.setOnClickListener {
            count++
            showStep(count = if (count > 4 ) 4 else count)
        }
        lav_click_left.setOnClickListener {
            count--
            showStep(count = if (count < 0 ) 0 else count)
        }
    }

    private fun showStep(count: Int) {
        when (count) {
            0 -> {
                setFooter(
                    isLeftVisible = false,
                    isRightVisible = true
                )
                setStepContent(
                    header = "Steps to follow during this CoronaVirus Quarantine!",
                    lottieAnimationFile = "fight_coronavirus.json"
                )
            }
            1 -> {
                setFooter(
                    isLeftVisible = true,
                    isRightVisible = true
                )
                setStepContent(header = "1. Maintain Social Distancing!", lottieAnimationFile = "social_distancing.json")
            }
            2 -> {
                setFooter(
                    isLeftVisible = true,
                    isRightVisible = true
                )
                setStepContent(header = "2. Stay Home, Stay Safe!", lottieAnimationFile = "stay_safe.json")
            }
            3 -> {
                setFooter(
                    isLeftVisible = true,
                    isRightVisible = true
                )
                setStepContent(header = "3. Wash/Sanatize your hands!", lottieAnimationFile = "sanatize.json")
            }
            4 -> {
                setFooter(
                    isLeftVisible = true,
                    isRightVisible = false
                )
                setStepContent(header = "4. Learn/Upgrade your skill set!", lottieAnimationFile = "learn.json")
            }
        }
    }

    private fun setStepContent(header: String, lottieAnimationFile: String) {
        tv_headline.text = header
        lav_main?.apply {
            setAnimation(lottieAnimationFile)
            repeatCount = 5
            playAnimation()
        }
    }

    private fun setFooter(
        isLeftVisible: Boolean,
        isRightVisible: Boolean
    ) {
        lav_click_left?.apply {
            visibility = if (isLeftVisible) View.VISIBLE else View.GONE
        }
        lav_click_right?.apply {
            visibility = if (isRightVisible) View.VISIBLE else View.GONE
        }

    }
}
