#include <detpic32.h>


void delay(unsigned int ms){
    resetCoreTimer();
    while(readCoreTimer() < 20000 * ms);
}

int main(void){

    TRISCbits.TRISC14 = 0; // RC14 = Output
    while(1){
        delay(500);
        LATCbits.LATC14 = !LATCbits.LATC14;
    }
    return 0;
}