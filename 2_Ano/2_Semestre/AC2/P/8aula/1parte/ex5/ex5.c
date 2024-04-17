#include <detpic32.h>

// a)   T1:     k = 20000000/(5*65536) = 61,03515625
//              PR1 = 20000000/(5*64) - 1 = 62499
//      T3:     k = 20000000/(25*65536) = 12,20703125
//              PR3 = 20000000/(25*16) = 49999   

int main(void){

    TRISDbits.TRISD0 = 0;
    TRISDbits.TRISD2 = 0;
    LATDbits.LATD0 = 0;
    LATDbits.LATD2 = 0;
    T3CONbits.TCKPS = 4; // 1:16 prescaler
    PR3 = 49999;    // Fout = 20MHz / (25*16) - 1 = 49999
    TMR3 = 0;

    T1CONbits.TCKPS = 2;
    PR1 = 62499;
    TMR1 = 0;

    T1CONbits.TON = 1;
    T3CONbits.TON = 1;

    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6]) (IPC3 might change -> check datasheet)
    IEC0bits.T3IE = 1; // Enable timer T3 interrupts (IEC0 might change -> check datasheet)
    IFS0bits.T3IF = 0; // Reset timer T3 interrupt flag (IFS0 might change -> check datasheet)

    IPC1bits.T1IP = 2;
    IEC0bits.T1IE = 1;
    IFS0bits.T1IF = 0;

    EnableInterrupts();
    while(1);
    return 0;
}

void _int_(4) isr_T1(void){
    // putChar('1');
    LATDbits.LATD0 = !LATDbits.LATD0;
    IFS0bits.T1IF = 0;
}

void _int_(12) isr_T3(void){
    // putChar('3');
    LATDbits.LATD2 = !LATDbits.LATD2;
    IFS0bits.T3IF = 0;
}
