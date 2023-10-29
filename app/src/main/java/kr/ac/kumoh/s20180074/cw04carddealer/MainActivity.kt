package kr.ac.kumoh.s20180074.cw04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20180074.cw04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(){
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        // TODO: 액티비티 초기화
        main = ActivityMainBinding.inflate(layoutInflater)

        val c = Random.nextInt(52) // 52장 중 랜덤으로 뽑기
        Log.i("뽑힌숫자", "${c}")
        // getCardName() : 숫자에 해당하는 파일명 얻어오기
        // getIdentifier() : 원하는 파일명, 찾고자 하는 res 내의 폴더명, 패키지명으로 해당 리소스의 id를 얻어오기
        val res = resources.getIdentifier(getCardName(c), "drawable", packageName)

        main.card1.setImageResource(res) // 해당 리소스로 이미지 설정하기

        setContentView(main.root)
    }

    fun getCardName(c: Int): String{
        val shape = when(c / 13){
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        val number = when(c % 13){
            0 -> "ace"
            in 1..9 -> "${c % 13}"
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}