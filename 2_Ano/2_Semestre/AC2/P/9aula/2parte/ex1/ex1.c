#include <detpic32.h>

int main(void){
    // 100 Hz
    // TCKPS = 2
    // PR3 = 49999

    T3CONbits.TCKPS = 2; 
    PR3 = 49999;
    TMR3 = 0;
    T3CONbits.TON = 1;

    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 1;
    OC1RS = 5000;
    OC1CONbits.ON = 1;

    while(1);
    return 0;
}