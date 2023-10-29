package kr.ac.kumoh.s20180074.cw04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20180074.cw04carddealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        // TODO: 액티비티 초기화
        main = ActivityMainBinding.inflate(layoutInflater)
//        main.card1.setImageResource(R.drawable.c_red_joker)
        setContentView(main.root)

        main.input.setOnClickListener{
            main.card1.setImageResource(R.drawable.c_red_joker)
        }
    }
}