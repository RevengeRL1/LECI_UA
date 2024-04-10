#include <detpic32.h>
// x0000000xxxxxxxx


int main(void){
    TRISB = TRISB & 0x80FF

    LATDbits.LATD5 = 1;
    LATDbits.LATD6 = 0;


    while(1){
        c = getChar();

        if(c == 'a' || c == 'A') LATB & 0x0100;
        else if(c == 'b' || c == 'B') LATB & 0x0200;
        else if (c == 'g' || c == 'G') LATB & 0x4000;
    }
    return 0;
}
