#include <detpic32.h>

int main(void){
    
    T3CONbits.TCKPS = 7; // 1:256 prescaler (i.e fout_presc = 20*10⁶/256 KHz) -> prescaler vai de 0 a 7 (1 a 256)
    PR3 = 39062;    // Fout = 20MHz / (2*256) - 1 = 39061.5
    TMR3 = 0;
    T3CONbits.TON = 1;

    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6]) (IPC3 might change -> check datasheet)
    IEC0bits.T3IE = 1; // Enable timer T3 interrupts (IEC0 might change -> check datasheet)
    IFS0bits.T3IF = 0; // Reset timer T3 interrupt flag (IFS0 might change -> check datasheet)

    EnableInterrupts();
    while(1){

    }
    return 0;

}

void _int_(12) isr_T3(void){
    static int i = 0;
    if(i % 2 == 0){putChar('.');}
    i++;
    IFS0bits.T3IF = 0; // Reset timer T3 interrupt flag
}
