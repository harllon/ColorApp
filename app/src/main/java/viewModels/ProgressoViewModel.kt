package viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressoViewModel: ViewModel() {
    //RGB color progress value
    var progressoR = MutableLiveData<Int>()
    var progressoG = MutableLiveData<Int>()
    var progressoB = MutableLiveData<Int>()

    //HSV color progress value
    var progressoH = MutableLiveData<Float>()
    var progressoS = MutableLiveData<Float>()
    var progressoV = MutableLiveData<Float>()
    var hsv = MutableLiveData<FloatArray>()
    //val hsvInit
    fun initialize(){
        hsv.value = FloatArray(3)
        progressoH.value = 0F
        progressoS.value = 0F
        progressoV.value = 0F
    }
    fun setArray(){
        if(getH() != null){
            hsv.value = floatArrayOf(progressoH.value!!, progressoS.value!!, progressoV.value!!)
        }
        if(getS() != null){
            hsv.value = floatArrayOf(progressoH.value!!, progressoS.value!!, progressoV.value!!)
        }
        if(getV() != null){
            hsv.value = floatArrayOf(progressoH.value!!, progressoS.value!!, progressoV.value!!)
        }
    }

    //control variables
    var fromUser = false
    var fromHexRed = false
    var fromHexBlue = false
    var fromHexGreen = false

    fun setR(value: Int, AccessMode: Boolean = false){
        progressoR.value = value
        fromUser = AccessMode
    }
    fun setG(value: Int, AccessMode: Boolean = false){
        progressoG.value = value
        fromUser = AccessMode
    }
    fun setB(value: Int, AccessMode: Boolean = false){
        progressoB.value = value
        fromUser = AccessMode
    }
    fun getR() : Int?{
        return progressoR.value
    }
    fun getG() : Int?{
        return progressoG.value
    }
    fun getB() : Int? {
        return progressoB.value
    }

    fun getAccessMode(): Boolean{
        return fromUser
    }

    fun setH(value: Float){
        progressoH.value = value
        setArray()
    }
    fun setS(value: Float){
        progressoS.value = value
        setArray()
    }
    fun setV(value: Float){
        progressoV.value = value
        setArray()
    }
    fun getH(): Float?{
        return progressoH.value
    }
    fun getS(): Float?{
        return progressoS.value
    }
    fun getV(): Float?{
        return progressoV.value
    }
}