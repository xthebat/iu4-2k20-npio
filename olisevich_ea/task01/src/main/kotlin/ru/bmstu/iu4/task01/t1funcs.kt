package ru.bmstu.iu4.task01


fun qSort(ar: ArrayList<Int>, start: Int = 0, stop: Int = ar.size-1){
    require(ar.isNotEmpty()) { "Can't sort empty array"}
    val support: Int = start;
    var fixLeft: Int = -1;
    var fixRight: Int = -1;
    var left: Int = start+1;
    var right: Int = stop;

    if (stop-start <1) return;
    //if (Start.dev) Start.log.info { "Selected support:  ${support}}" }

    while(left < right){

        if ( fixLeft<0 ) {

            if (ar[left] > ar[support]) {
                fixLeft = left;
                //if (Start.dev) Start.log.info { "To right side:  ${ar[left]}}" }
            } else
                left++;
        }
        if ( fixRight<0 ) {

            if (ar[right] < ar[support]) {
                fixRight = right;
                //if (Start.dev) Start.log.info { "To left side:  ${ar[right]}}" }
            } else
                right--;
        }

        if ( fixRight >= 0 && fixLeft >= 0){
            //if (Start.dev) Start.log.info { "Try to swap: ${fixLeft} to ${fixRight}" }
            arSwap(ar, right, left);
            fixLeft = -1;
            fixRight = -1;
            left++;
            right--;
        }
    }
    if ( ar[start] > ar[right] ){

        arSwap(ar, right, start);

        //if (Start.dev) Start.log.info { "Try to set place: ${fixLeft} to ${fixRight}" }
    }

    qSort(ar, start, right - 1);
    qSort(ar, right, stop);
}

fun arSwap(ar: ArrayList<Int>, i: Int, j: Int ){
    ar[i] = ar[j].also{ ar[j] = ar[i] };
}
