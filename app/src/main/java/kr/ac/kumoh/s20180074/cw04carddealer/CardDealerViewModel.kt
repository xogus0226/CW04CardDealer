package kr.ac.kumoh.s20180074.cw04carddealer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardDealerViewModel : ViewModel() {
    private var _cards = MutableLiveData(IntArray(5){ -1 })
    val cards: LiveData<IntArray> get() = _cards

    fun shuffle(){
        var randNum = 0
        val newCards = IntArray(5) { -1 }
        for(i in newCards.indices){
            do{
                randNum = Random.nextInt(52)

            }while (newCards.contains(randNum))
            newCards[i] = randNum
        }
        newCards.sort()
        _cards.value = newCards
    }
}