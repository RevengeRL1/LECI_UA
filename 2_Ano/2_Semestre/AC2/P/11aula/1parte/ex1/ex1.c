#include <detpic32.h>
// Acima de 115200 -> fator divisão 4

void putc(char byte){
    while(U2STAbits.UTXBF == 1);
    U2TXREG = byte;
}

void putstr(char *str){
    while(*str != '\0'){
        putc(*str);
        str++;
    }
}


int main(void){
    // Configurar UART2

    U2MODEbits.BRGH = 1;
    U2BRG = 42;
    U2MODEbits.PDSEL = 0;
    U2MODEbits.STSEL = 0;
    U2STAbits.UTXEN = 1;
    U2STAbits.URXEN = 1;
    U2MODEbits.ON = 1;

    // Configurar os interrupts da UART2
    IEC1bits.U2RXIE = 1;
    IEC1bits.U2TXIE = 0;
    IPC8bits.U2IP = 2;
    IFS1bits.U2RXIF = 0;
    U2STAbits.URXISEL = 0;

    EnableInterrupts();
    while(1);
    return 0;

}


void _int_(32) isr_uart2(void)
{
 unsigned char car = 0;
 if (IFS1bits.U2RXIF == 1){
    car = U2RXREG;
    if (car == '?'){
        putstr("AC2 - Guiao 11");
    }
    else{
        putc(car);

    }
    IFS1bits.U2RXIF = 0;
 }   
}

