package kr.ac.kumoh.s20180074.cw04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.s20180074.cw04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(){
    private lateinit var _main : ActivityMainBinding
    private lateinit var _imgViews : Array<ImageView>
    private lateinit var _model: CardDealerViewModel
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        // 필요한 변수들 초기화
        _main = ActivityMainBinding.inflate(layoutInflater)
        _imgViews = arrayOf(_main.card1, _main.card2, _main.card3, _main.card4, _main.card5)
        _model = ViewModelProvider(this)[CardDealerViewModel::class.java]

        // 화면 렌더링
        setImageViews() // 최초 실행 시 모든 카드를 조커로 보이기
        setContentView(_main.root)

        // 클릭 이벤트 리스너 달기
        _main.btnShuffle.setOnClickListener{ shuffleAndRender() }
    }

    fun getCardName(c: Int): String{
        when(c){
            -1 -> return "c_black_joker"
        }
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

    fun setImageViews() {
        _imgViews.forEachIndexed{index, eachImageView ->
            val idCard = resources.getIdentifier(getCardName(_model.cards.value!![index]), "drawable", packageName)
            eachImageView.setImageResource(idCard)
        }
    }

    fun shuffleAndRender(){
        _model.shuffle()
        setImageViews()
    }
}