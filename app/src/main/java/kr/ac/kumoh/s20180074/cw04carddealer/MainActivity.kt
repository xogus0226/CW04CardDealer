package kr.ac.kumoh.s20180074.cw04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import kr.ac.kumoh.s20180074.cw04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(){
    private lateinit var _main : ActivityMainBinding
    private lateinit var _imgViews : Array<ImageView>
    private lateinit var _numbers : IntArray
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        // TODO: 액티비티 초기화
        _main = ActivityMainBinding.inflate(layoutInflater)
        _imgViews = arrayOf(_main.card1, _main.card2, _main.card3, _main.card4, _main.card5)
        _numbers = IntArray(5) { -1 }

        // _numbers에 중복없이 랜덤 숫자를 채우기
        var randNum = 0
        for(i in _numbers.indices){
            do{
                randNum = Random.nextInt(52)

            }while (_numbers.contains(randNum))
            _numbers[i] = randNum
        }
        _numbers.sort()
        Log.i("리스트", "${_numbers[0]} ${_numbers[1]} ${_numbers[2]} ${_numbers[3]} ${_numbers[4]}")

        // _numbers 각각의 숫자에 대응되는 파일명으로 변환하고, 모든 이미지 뷰들의 이미지를 이것으로 설정하기
        _imgViews.forEachIndexed{index, eachImageView ->
            val idCard = resources.getIdentifier(getCardName(_numbers[index]), "drawable", packageName)
            eachImageView.setImageResource(idCard)
        }

        setContentView(_main.root)
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
            in 1..9 -> "${c % 13 + 1}"
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}