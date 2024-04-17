#include <detpic32.h>

int main(void){
    T3CONbits.TCKPS = 7; // 1:256 prescaler (i.e fout_presc = 20*10⁶/256 KHz) -> prescaler vai de 0 a 7 (1 a 256)
    PR3 = 39062;    // Fout = 20MHz / (2*256) - 1 = 39061.5
    TMR3 = 0;
    T3CONbits.TON = 1;

    while(1){
        while(IFS0bits.T3IF == 0);
        IFS0bits.T3IF = 0;
        putChar('.');
    }
    return 0;
}
