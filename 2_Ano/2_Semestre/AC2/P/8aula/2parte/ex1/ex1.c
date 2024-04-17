#include <detpic32.h>

int main(void){
    TRISDbits.TRISD8 = 1;
    TRISEbits.TRISE0 = 0;

    LATEbits.LATE0 = 0;

    while(1){
        if (PORTDbits.RD8 == 0){ // Transição negativa -> ver esquema do porto RD8
            LATEbits.LATE0 = 1;
            resetCoreTimer();
            while(readCoreTimer() < 3*20000000); // 3 seconds
        } 

        else { LATEbits.LATE0 = 0; }
    }
    return 0;
}
