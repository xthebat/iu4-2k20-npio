import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object Start {

    val input: ArrayList<Int> = arrayListOf();
    val count: Int = 12;

    val dev: Boolean = false;
    val log = logger(FINEST);

    @JvmStatic
    fun main(args: Array<String>) {
        while (input.size < count) { input.add((0..999).random()) };

        testSwap();
        testAr();

        log.fine { "Load Input:  ${input.toString()} " }
        qSort(input)
        log.fine { "Unload Output: ${input} "}
    }


    fun qSort(ar: ArrayList<Int>, start: Int = 0, stop: Int = ar.size-1){
        val support: Int = start;
        var fixLeft: Int = -1;
        var fixRight: Int = -1;
        var left: Int = start+1;
        var right: Int = stop;

        if (stop-start <1) return;
        if (dev) log.info { "Selected support:  ${support}}" }

        while(left < right){

            if ( fixLeft<0 ) {

                if (ar[left] > ar[support]) {
                    fixLeft = left;
                    if (dev) log.info { "To right side:  ${ar[left]}}" }
                } else
                    left++;
            }
            if ( fixRight<0 ) {

                if (ar[right] < ar[support]) {
                    fixRight = right;
                    if (dev) log.info { "To left side:  ${ar[right]}}" }
                } else
                    right--;
            }

            if ( fixRight >= 0 && fixLeft >= 0){
                if (dev) log.info { "Try to swap: ${fixLeft} to ${fixRight}" }
                arSwap(ar, right, left);
                fixLeft = -1;
                fixRight = -1;
                left++;
                right--;
            }
        }
            if ( ar[start] > ar[right] ){

                arSwap(ar, right, start);

                if (dev) log.info { "Try to set place: ${fixLeft} to ${fixRight}" }
            }

        qSort(ar, start, right-1);
        qSort(ar, right, stop);
    }

    fun arSwap(ar: ArrayList<Int>, i: Int, j: Int ){
        ar[i] = ar[j].also{ ar[j] = ar[i] };
    }

    var testar1: ArrayList<Int> = arrayListOf( 1 , 0 , 0 , 0 , 0);
    val truear1: ArrayList<Int> = arrayListOf( 0 , 0 , 0 , 0 , 1);

    fun testAr(){
        qSort((testar1));


        if (testar1.equals(truear1))
            log.fine{"qSort test good"}
        else log.severe { "qSort test failed" }

    }

    fun testSwap(){
        var inpar: ArrayList<Int> = arrayListOf( 10, 5 )
        val outar: ArrayList<Int> = arrayListOf( 5, 10 )

        arSwap( inpar, 0, 1);

        if (inpar.equals(outar))
            log.fine{"Swap test good"}
        else log.severe { "Swap test failed" }

    }


}


