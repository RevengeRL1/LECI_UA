#include <detpic32.h>

int main(void){
    unsigned char segment;
    // Configure RD5 - RD6 as outputs
    TRISDbits.TRISD5 = 0; 
    TRISDbits.TRISD6 = 0;

    // Configure RB8 - RB14 as outputs;
    TRISB = TRISB & 0x80FF; 

    // Enable RD5 and disable RD6
    LATD = (LATD | 0x0020) & 0xFFBF; 

    while(1){
        segment = 1;
        int i;
        for (i = 0; i < 7; i++){

            // Align the segment value with range RB8 - RB14
            LATB = (LATB & 0x80FF) | segment << 8;

            // Wait 0.5s (2Hz)
            resetCoreTimer();
            while(readCoreTimer() < 10000000);
            segment = segment << 1;
        }

        // Switch displays (with XOR)
        LATD = LATD ^0x0060;
    }
    
    return 0;
    
}

