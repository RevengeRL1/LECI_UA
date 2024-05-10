#include <detpic32.h>

// U2BRG = 20000000/(16*115200) - 1 = 9,85 ~ 10 (inteiro mais proximo) 
// 16 -> porque o fator de divisão pedido é 16
// 115200 porque são os bps pedidos

int main(void){
    U2MODEbits.BRGH = 0;
    U2BRG = 10;
    U2MODEbits.PDSEL = 0;
    U2MODEbits.STSEL = 0;
    U2STAbits.UTXEN = 1;
    U2STAbits.URXEN = 1;
    U2MODEbits.ON = 1;
}

