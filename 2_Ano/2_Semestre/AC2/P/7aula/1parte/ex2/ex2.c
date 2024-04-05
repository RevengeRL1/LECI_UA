#include <detpic32.h>


void send2displays(unsigned char value){
    static const char disp7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
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

unsigned char toBcd(unsigned char value) { 
   return ((value / 10) << 4) + (value % 10); 
}

volatile unsigned char voltage = 0;
int main(void)
{
    unsigned int cnt = 0;

    TRISBbits.TRISB4 = 1;       // RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      // RB4 configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger constant
    AD1CON1bits.CLRASAM = 1;    // Stop conversion when the 1st A/D converter intetupr is generated.
                                // At the same time, hardware clears ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100ns)
    AD1CON2bits.SMPI = 8 - 1;       // Interrupt is generated after 1 sample
    AD1CHSbits.CH0SA = 4;       // analog channel input 4
    AD1CON1bits.ON = 1;         // Enable the A/d configuration sequence

    // Enable interrupts ADC
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IFS1bits.AD1IF = 0;         // clear A/D interrupt flag
    IEC1bits.AD1IE = 1;         // enable A/D interrupts

    TRISB = TRISB & 0x80FF;     // Configure 
    TRISD = TRISD & 0xFF9F;     // displays
    
    EnableInterrupts();

    AD1CON1bits.ASAM = 1;       // Start conversion

    while (1) { 
        if (cnt == 0){
            AD1CON1bits.ASAM = 1;
        }
        send2displays(toBcd(voltage));
        cnt = (cnt + 1) % 20;
        resetCoreTimer();
        while(readCoreTimer() < 200000);
    }
       
    return 0;
}

//Interrupt handler
void _int_(27) isr_adc(void)
{
    int *p = (int *)(&ADC1BUF0), VAL_AD = 0;
    for(; p <= (int *)(&ADC1BUFF); p+=4){
        VAL_AD += *p;
    }

    VAL_AD = VAL_AD / 8;
    voltage = (VAL_AD * 33+511) / 1023;
    IFS1bits.AD1IF = 0;
}
