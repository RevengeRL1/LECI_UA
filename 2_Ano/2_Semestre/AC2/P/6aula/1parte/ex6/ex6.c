#include <detpic32.h>

// O programa deverá: 
// i) efetuar 5 sequências de conversão A/D por segundo (frequência de amostragem de 5 Hz), cada uma delas com 4 amostras; 
// ii) enviar informação para o sistema de visualização a cada 10 ms (frequência de refrescamento de 100 Hz);

int main(void) { 
    
    unsigned int x = 4;
    unsigned int N = 4;
    unsigned int i;
    unsigned int average;
    unsigned int tensao = 0;

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

    i = 0; 
    while(1) { 
        if(i == 0) {  // 0, 200ms, 400ms, 600ms, ... 
         
            // reset average
            average = 0;

            // Convert analog input (4 samples) 

            // Start conversion 
            AD1CON1bits.ASAM = 1;

            // Wait while conversion not done (AD1IF == 0) 
            while( IFS1bits.AD1IF == 0 );

            int *p = (int *)(&ADC1BUF0); 

            // Read samples and calculate the average
            for( i = 0; i < 4; i++ ) { 
                average += p[i*4];
            }
            average /= 4;

            // Calculate voltage amplitude 
            tensao = (average*33 + 511) / 1023; 

            // Convert voltage amplitude to decimal
            tensao = toBcd(tensao);
        } 

        // Send voltage value to displays
        send2displays(tensao);

        // Wait 10 ms (using the core timer) 
        delay(10);

        i = (i + 1) % 20; 
    } 
    return 0; 
}

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