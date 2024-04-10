#include <detpic32.h>


// 4,6Hz = 0,217391304s
// 0,217391304 * 20000000 = 4347826,08 ~ 4347826
int main(void){
    TRISEbits.TRISE6 = 0;
    TRISEbits.TRISE5 = 0;
    TRISEbits.TRISE4 = 0;
    TRISEbits.TRISE3 = 0;

    // TRISE = TRISE & 0xFF87 (1111111110000111)
    unsigned int counter = 0;
    while(1){

        LATE = (LATE & 0xFF87) | counter << 3;

        resetCoreTimer();
        while(readCoreTimer() < 4347826);

        counter = (counter + 1) % 10; // Modulo 10
    }

    return 0;
}