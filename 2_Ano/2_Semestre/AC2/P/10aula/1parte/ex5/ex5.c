#include <detpic32.h>

// U2BRG = 20000000/(16*115200) - 1 = 9,85 ~ 10 (inteiro mais proximo) 
// 16 -> porque o fator de divisão pedido é 16
// 115200 porque são os bps pedidos
    
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
    U2MODEbits.BRGH = 0;
    U2BRG = 10;
    U2MODEbits.PDSEL = 0;
    U2MODEbits.STSEL = 0;
    U2STAbits.UTXEN = 1;
    U2STAbits.URXEN = 1;
    U2MODEbits.ON = 1;

    while(1){
        putstr("String de teste\n");
        resetCoreTimer();
        while(readCoreTimer() < 20000000);
    }

    return 0;
}
