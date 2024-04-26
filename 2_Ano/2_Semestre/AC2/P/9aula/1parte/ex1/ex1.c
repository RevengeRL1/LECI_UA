#include <detpic32.h>

// O programa deverá: 
// i) efetuar 5 sequências de conversão A/D por segundo (frequência de amostragem de 5 Hz), cada uma delas com 8 amostras; 
// ii) enviar informação para o sistema de visualização a cada 10 ms (frequência de refrescamento de 100 Hz);


void send2displays(unsigned char value) { 

    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 
                                    0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    unsigned char digit_low, digit_high;

    // static variable: doesn't loose its value between calls to function 
    static char displayFlag = 0; 
    digit_low = value & 0x0F; 
    digit_high = value >> 4; 

    // if "displayFlag" is 0 then send digit_low to display_low 
    // else send digit_high to didplay_high 
    if(displayFlag == 0){

        // Selecionar o display 'low'
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;

        LATB = (LATB & 0x80FF) | display7Scodes[digit_low] << 8;

    }
    else if(displayFlag == 1){

        // Selecionar o display 'high'
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;

        LATB = (LATB & 0x80FF) | display7Scodes[digit_high] << 8;

    }

    // toggle "displayFlag" variable
    displayFlag = !displayFlag; 
}

unsigned char toBcd(unsigned char value) { 
   return ((value / 10) << 4) + (value % 10); 
}

void delay(unsigned int ms){
    resetCoreTimer();
    while(readCoreTimer() < (20000 * ms));
}


// k_T1 = (20*10⁶)/5*65536 = 61.035 -> 64 ; TCKPS = 2
// PR1 = (20*10⁶) / 5*64 - 1 = 62499
// k_T3 = 3.051 -> k = 4
// PR3 = 49999

volatile unsigned char volt_dec = 0;
int main(void) { 
    unsigned int x = 4;
    unsigned int N = 8;

    // Desligar o OUTPUT digital de RB4;
    TRISBbits.TRISB4 = 1;

    // Ligar o INPUT analogico de RB4;
    AD1PCFGbits.PCFG4 = 0;

    // Ligar o OUTPUT do enable dos displays
    TRISD = TRISD & 0xFF9F; // (1111 1111 1001 1111) 

    // Ligar o OUTPUT dos displays (RB8 - RB14)
    TRISB = TRISB & 0x80FF; // (1000 0000 1111 1111)

    AD1CON1bits.SSRC = 7; 
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;     
    AD1CON2bits.SMPI = N-1;
    AD1CHSbits.CH0SA = x;
    AD1CON1bits.ON = 1;

    T3CONbits.TCKPS = 2; 
    PR3 = 49999;
    TMR3 = 0;

    T1CONbits.TCKPS = 2;
    PR1 = 62499;
    TMR1 = 0;
    T3CONbits.TON = 1;
    T1CONbits.TON = 1;

    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IFS1bits.AD1IF = 0;         // clear A/D interrupt flag
    IEC1bits.AD1IE = 1;         // enable A/D interrupts

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


void _int_(27) isr_adc(void){
    int VAL_AD = 0, V;

    int *p = (int *) (&ADC1BUF0);
    for(; p <= (int *) (&ADC1BUFF); p+=4){
        VAL_AD += *p;
    }
    VAL_AD = VAL_AD/8;

    V=(VAL_AD*33 + 511)/1023;
    VAL_AD = 0;

    volt_dec = toBcd(V);
    IFS1bits.AD1IF = 0;
}

void _int_(4) isr_T1(void){
    AD1CON1bits.ASAM = 1;
    IFS0bits.T1IF = 0;
}

void _int_(12) isr_T3(void){
    send2displays(volt_dec);
    IFS0bits.T3IF = 0;
}

