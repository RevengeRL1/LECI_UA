#include <detpic32.h>

// 2,3Hz = 0,434782609s
// 2,3Hz -> 8695652

// 5,2Hz -> 3846154
//xxxxxxxxxx0000xx
int main(void){

    // 1111 1111 1100 0011
    TRISEbits.TRISE5 = 0;
    TRISEbits.TRISE4 = 0;
    TRISEbits.TRISE3 = 0;
    TRISEbits.TRISE2 = 0;

    int counter = 0;

    TRISBbits.TRISB2 = 1;

    int freq;
    while(1){
        if(PORTBbits.PORTB2 == 1) freq = 3846154;
        else freq = 8695652;

        LATE = (LATE & 0xFFC3) | counter << 2;

        resetCoreTimer()
        while(readCoreTimer() < freq);

        counter = (counter + 1) % 10;
    }
}