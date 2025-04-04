#include <detpic32.h>

// U2BRG = 20000000/(4*115200) - 1 = 42.4 ~ 42 (inteiro mais proximo) 
// 4 -> porque o fator de divisão pedido é 4
// 115200 porque são os bps pedidos
    
void putc(char byte){
    while(U2STAbits.UTXBF == 1);
    U2TXREG = byte;
}


int main(void){
    U2MODEbits.BRGH = 1;
    U2BRG = 42;
    U2MODEbits.PDSEL = 0;
    U2MODEbits.STSEL = 0;
    U2STAbits.UTXEN = 1;
    U2STAbits.URXEN = 1;
    U2MODEbits.ON = 1;

    while(1){
        putc('+');
        resetCoreTimer();
        while(readCoreTimer() < 20000000);
    }

    return 0;
}
