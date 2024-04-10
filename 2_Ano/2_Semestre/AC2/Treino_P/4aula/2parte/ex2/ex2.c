#include <detpic32.h>

int main(void){
    TRISB = TRISB & 0x80FF;
    LATD = LATD & 0xFF9F;

    LATDbits.LATD5 = 1;
    LATDbits.LATD6 = 0;

    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;

    while(1){
        segment = 1;
        for(i = 0; i < 7; i++){
            LATB = (LATB & 0x80FF) | segment << 8;
            resetCoreTimer();
            while(readCoreTimer() < 10000000);
            segment = segment << 1;

        }
        
        LATD = LATD ^0x0060;


    }
}


// Displays:
// 0 = 0111111 = 0x3F
// 1 = 0000110 = 0x06
// 2 = 1011011 = 0x5B