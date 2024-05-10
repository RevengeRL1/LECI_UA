#include <detpic32.h>

// U2BRG = 20000000/(16*115200) - 1 = 9,85 ~ 10 (inteiro mais proximo) 
// 16 -> porque o fator de divisão pedido é 16
// 115200 porque são os bps pedidos
    
void putc(char byte){
    while(U1STAbits.UTXBF == 1);
    U1TXREG = byte;
}

void putstr(char *str){
    while(*str != '\0'){
        putc(*str);
        str++;
    }
}


int main(void){
    U1MODEbits.BRGH = 0;
    U1BRG = 10;
    U1MODEbits.PDSEL = 1;
    U1MODEbits.STSEL = 0;
    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;
    U1MODEbits.ON = 1;

    while(1){
        putstr("0x5A");
        resetCoreTimer();
        while(readCoreTimer() < 20000000);
    }

    return 0;
}
