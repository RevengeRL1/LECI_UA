#include <detpic32.h>

void send2displays(unsigned char value){
    static const char disp7Scodes[] = {0x3F, 0x06, 0x5B, 0x47, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    unsigned int dh, dl;
    static char displayFlag = 0; // Static variable: doesn't lose its 
                                 // value between function calls

    dl = value & 0x0F;
    dh = value >> 4;
    if (displayFlag == 0){
        LATD = (LATD & 0xFF9F) | 0x0020;
        LATB = (LATB & 0x80FF) | (disp7Scodes[dl] << 8);
    }
    else {
        LATD = (LATD & 0xFF9F) | 0x0040;
        LATB = (LATB & 0x80FF) | (disp7Scodes[dh] << 8);
    }

    // Invert displayFlag
    displayFlag ^= 1;
}


int main(void){
    // Configure RB8 - RB14 as outputs
    TRISB = TRISB & 0x80FF; 

    // Configure RD5 - RD6 as outputs
    TRISDbits.TRISD5 = 0; 
    TRISDbits.TRISD6 = 0;

    while(1){
        send2displays(0x15);

        // Wait 0.2s
        resetCoreTimer();
        while(readCoreTimer() < 4000000 /*0.2 * 20000000*/);
    }
    return 0;
}